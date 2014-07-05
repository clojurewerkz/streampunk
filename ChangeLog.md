# Streampunk Change Log

## Changes Between 1.0.0-beta1 and 1.0.0-beta2

### HyperLogLog+ Support

`clojurewerkz.streampunk.stream-lib.hyper-log-log/hll-plus` is a new function
that instantiates a `HyperLogLogPlus` instance. Existing
`clojurewerkz.streampunk.stream-lib.hyper-log-log` functions
now support it together with `HyperLogLog` instances.

``` clojure
(require '[clojurewerkz.streampunk.stream-lib.hyper-log-log :as hll])

(let [n  10000000
      hl (hll/hll-plus 10)]
  (doseq [x (range 0 n)]
    (hll/offer hl x))
  (hll/cardinality hl))

(let [n  10000000
      hl (hll/hll-plus 20 30)]
  (doseq [x (range 0 n)]
    (hll/offer hl x))
  (hll/cardinality hl))
```


## Initial Release: 1.0.0-beta1

Initial release. Provides (highly experimental)
interfaces to some of the stream-lib features:

 * TopK
 * Q Digest
 * T Digest
 * HyperLogLog
