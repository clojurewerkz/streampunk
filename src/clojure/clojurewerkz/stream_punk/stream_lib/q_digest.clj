(ns clojurewerkz.stream-punk.stream-lib.q-digest
  (:import [com.clearspring.analytics.stream.quantile IQuantileEstimator QDigest]))

;;
;; API
;;

(defn q-digest
  [^double compression-factor]
  (QDigest. compression-factor))

(defn offer
  [^IQuantileEstimator algo ^long val]
  (.offer algo val))

(defn ^long get-quantile
  [^IQuantileEstimator algo ^double q]
  (.getQuantile algo q))
