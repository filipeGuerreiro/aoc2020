(ns aoc.day23
  (:require [clojure.string :as str]))

:input "1 2 3 4 5 6 7"
:output [ 1 2 3 4 5 6 7 ]
(defn- parse
  [in]
  (as-> in $
      (str/split $ #"")
      (map #(Integer/parseInt %) $)
      (into [])))
:input 4 '(3 8 9 1) 9
:output 6
(defn- find-dest
  [val picked-up max]
  (loop [val val]
    (if (picked-up val)
      (recur (mod (dec val) max))
      val)))
:input [1 2 3 4 5 6]
:output [1 3 4 5 6 2]
(defn- crab-move
  [cups]
  (let [cup-circle (lazy-seq (cycle cups))
        curr (first cup-circle)
        picked-up (take 3 (drop 1 cup-circle))
        dest (find-dest (dec curr) (into #{} picked-up) (count cups))]
    (loop [cups' cups]
      (if ())
      (recur []))))
:input [1 2 3 4] 10
:output [3 2 1 4]
(defn- do-moves
  [cups n]
  (let [size [count cups]]
    (loop [n' n cups' cups]
      (if (= 0 n')
        cups'
        (recur (dec n') (crab-move cups'))))))
(defn part-1
  [in]
  (let [cups (parse in)]
    (do-moves cups 100)))

(defn part-2
  [in]
  in)
