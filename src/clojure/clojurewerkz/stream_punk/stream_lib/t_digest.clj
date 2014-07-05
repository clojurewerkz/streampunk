(ns clojurewerkz.stream-punk.stream-lib.t-digest
  (:import [com.clearspring.analytics.stream.quantile TDigest]))

;;
;; API
;;

(defn t-digest
  [^double compression-factor]
  (TDigest. compression-factor))

(defn offer
  ([^TDigest algo val]
     (offer algo val 1))
  ([^TDigest algo val weight]
     (.add algo ^double val ^long weight)))

(defn ^double get-quantile
  [^TDigest algo ^double q]
  (.quantile algo q))

(defn ^double cdf
  [^TDigest algo x]
  (.cdf algo ^double x))

(defn size
  [^TDigest algo]
  (.size algo))
