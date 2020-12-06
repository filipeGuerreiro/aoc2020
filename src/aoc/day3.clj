(ns aoc.day3
  (:require [clojure.string :as str]))

(defn- read-map
  [in]
  (->> in
       str/split-lines
       (map vec)
       vec))
(defn- run
  [in dx dy]
  (let [slopemap (read-map in)
        height   (count slopemap)
        width    (count (first slopemap))]
    (loop [cnt 0, x 0, y 0]
      (let [x' (mod x width)]
        (cond (>= y height)
              cnt
              :else
              (let [ch ((slopemap y) x')]
                (cond (= ch \#)
                      (recur (inc cnt) (+ x dx) (+ y dy))
                      :else
                      (recur cnt (+ x dx) (+ y dy)))))))))

(defn part-1
  [in]
  (run in 3 1))

(defn part-2
  [in]
  (let [slopes '((1 1) (3 1) (5 1) (7 1) (1 2))]
    (->> slopes
         (map #(run in (first %) (second %)))
         (apply *))))
