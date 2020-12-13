(ns aoc.util)

(defn spy
  [& args]
  (apply prn args)
  (last args))

(defn map-entry [k v]
  (clojure.lang.MapEntry/create k v))
