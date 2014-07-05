(ns clojurewerkz.streampunk.stream-lib.hyper-log-log
  "Interface to stream-lib's HyperLogLog implementation"
  (:import [com.clearspring.analytics.stream.cardinality ICardinality HyperLogLog
            HyperLogLogPlus]))

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

(defn ^ICardinality hll-plus
  "Creates a new HyperLogLogPlug instance using the specified
   precision parameters."
  ([p]
     (HyperLogLogPlus. p))
  ([p sp]
     (HyperLogLogPlus. p sp)))

(defn offer
  [^ICardinality algo obj]
  (.offer algo obj))

(defn ^long cardinality
  "Returns estimated cardinality"
  [^ICardinality algo]
  (.cardinality algo))
