(ns clojurewerkz.streampunk.stream-lib.hyper-log-log-test
  (:require [clojure.test :refer :all]
            [clojurewerkz.streampunk.stream-lib.hyper-log-log :as hll]))

(defn ^:private ensure-error-below
  [estimate size error]
  (let [d (/ (Math/abs (- estimate size)) (double size))]
    (is (< d error))))

(deftest test-cardinality
  (let [hl (hll/with-log2m 16)]
    (doseq [x [0 1 2 3 16 17 18 19 19]]
      (hll/offer hl x))
    (is (= 8 (hll/cardinality hl)))))

(deftest test-high-cardinality
  (testing "with log2m = 10"
    (let [n  10000000
          hl (hll/with-log2m 10)]
      (doseq [x (range 0 n)]
        (hll/offer hl x))
      (let [c (hll/cardinality hl)]
        (ensure-error-below c n 0.1))))
  (testing "with log2m = 20"
    (let [n  10000000
          hl (hll/with-log2m 20)]
      (doseq [x (range 0 n)]
        (hll/offer hl x))
      (let [c (hll/cardinality hl)]
        (ensure-error-below c n 0.01)))))

(deftest test-high-cardinality-with-defined-rds
  (testing "with rsd = 0.01"
    (let [n  10000000
          hl (hll/with-rsd 0.01)]
      (doseq [x (range 0 n)]
        (hll/offer hl x))
      (let [c (hll/cardinality hl)]
        (ensure-error-below c n 0.01)))))
