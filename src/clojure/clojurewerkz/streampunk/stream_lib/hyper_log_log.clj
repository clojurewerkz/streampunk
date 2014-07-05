(ns clojurewerkz.streampunk.stream-lib.hyper-log-log
  "Interface to stream-lib's HyperLogLog implementation"
  (:import [com.clearspring.analytics.stream.cardinality ICardinality HyperLogLog]))

;;
;; API
;;

(defn ^ICardinality with-rsd
  "Create a new HyperLogLog instance using the specified standard deviation.

   Smaller values require more space."
  [^double rsd]
  (HyperLogLog. rsd))

(defn ^ICardinality with-log2m
  "Create a new HyperLogLog instance using the specified log2m paramters.

   The log2m parameter defines the accuracy of
   the counter. The larger the log2m the better the accuracy."
  [n]
  (HyperLogLog. (Integer/valueOf n)))

(defn offer
  [^HyperLogLog algo obj]
  (.offer algo obj))

(defn ^long cardinality
  "Returns estimated cardinality"
  [^HyperLogLog algo]
  (.cardinality algo))
