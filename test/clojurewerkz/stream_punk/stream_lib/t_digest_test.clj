(ns clojurewerkz.stream-punk.stream-lib.t-digest-test
  (:require [clojure.test :refer :all]
            [clojurewerkz.stream-punk.stream-lib.t-digest :as qe]))

(deftest test-basic-quantile-calculation-with-t-digest
  (let [t (qe/t-digest 100)]
    (doseq [i (range 0 1000)]
      (qe/offer t i))
    (is (= 248.0 (qe/get-quantile t 0.25)))))

(deftest test-basic-quantile-calculation-with-1M-elements-t-digest
  (let [t (qe/t-digest 100)]
    (doseq [i (range 0 1000000)]
      (qe/offer t i))
    (is (> (Math/round (qe/get-quantile t 0.25))
           250000))))

(deftest test-cdf-calculation
  (let [t (qe/t-digest 100)]
    (doseq [i (range 0 1000)]
      (qe/offer t i))
    (is (= 0.5005 (qe/cdf t 500)))))

(deftest test-size-calculation
  (let [n 10000
        t (qe/t-digest 100)]
    (doseq [i (range 0 n)]
      (qe/offer t i))
    (is (= n (qe/size t)))))
