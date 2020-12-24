(ns aoc.day11
  (:require [clojure.string :as str]))

(defn- wall-row
  [size]
  (vec (repeat (+ 2 size) \L)))
(defn- buffer-row
  [row]
  `[~\L ~@(conj row \L)]) ; [ L [L . L L . .] L ]
(defn- rules
  [[prev-row row next-row]]
  (let [row' (buffer-row row)]
    ()
    (cond ())))
(defn- round
  [board]
  (for []))
(defn part-1
  [in]
  (let [board (str/split-lines in)
        row-size (count (get 0 board))
        wall (wall-row row-size)
        walled-lines (reverse (conj (reverse (conj board wall)) wall))]
    (for [i (range 0 (count board))])
       ()))

(defn- part-2
  [in]
  in)
