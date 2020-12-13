(ns aoc.util)

(defn spy
  [& args]
  (apply prn args)
  (last args))
