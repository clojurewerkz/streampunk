(ns clojurewerkz.stream-punk.stream-lib.quantile-estimation-test
  (:require [clojure.test :refer :all]
            [clojurewerkz.stream-punk.stream-lib.quantile-estimation :as qe]))

(deftest test-basic-quantile-calculation-with-q-digest
  (let [q (qe/q-digest 100)]
    (doseq [i (range 0 1000)]
      (qe/offer q i))
    (is (= 255 (qe/get-quantile q 0.25)))))
