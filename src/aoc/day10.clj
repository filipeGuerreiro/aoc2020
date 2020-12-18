(ns aoc.day10
  (:require [clojure.string :as str]
            [aoc.util :refer :all]))

:input [1 2 3 4 5 7 9]
:output {1 5, 3 4, 7 6}
(defn- count-diffs
  [adapters]
  (loop [adapters' adapters, diffs {}]
    (let [window (take 3 (drop 1 adapters'))
          pivot (first adapters')]
      (if (empty? window)
        diffs
        (->> window
             (map (fn [e] (- e pivot)))
             (map (fn [e] {e 1}))        ; '({1 1} {1 1} {3 1})
             (apply merge-with +)        ; {1 2} {3 1}
             (merge-with + diffs)
             (recur (drop 1 adapters')))))))
(defn part-1
  [in]
  (let [adapters (sort (map #(Integer/parseInt %) (str/split-lines in)))
        diffs (count-diffs adapters)]
    (spy diffs)
    (* (get diffs 1) (get diffs 3))))

(defn part-2
  [in]
  in)
