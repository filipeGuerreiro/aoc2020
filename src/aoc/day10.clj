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
             (map (fn [e] {e 1}))         ; '({1 1} {1 1} {3 1})
             (apply merge-with +)        ; {1 2} {3 1}
             (merge-with + diffs)
             (recur (drop 1 adapters')))))))
(defn- parse
  [in]
  (let [sorted-lines (sort (map #(Integer/parseInt %) (str/split-lines in)))]
    (concat '(0) sorted-lines (list (+ 3 (apply max sorted-lines))))))
(defn part-1
  [in]
  (let [adapters (parse in)
        diffs (count-diffs adapters)]
    (spy diffs)
    (* (get diffs 1) (get diffs 3))))

(defn- count-combinations-solver [nums]
  (def solver
    (memoize
      (fn [i]
        (if (zero? i)
          1
          (let [js  (filter #(<= 0 (- i %)) (range 1 4))
                js' (filter #(<= (- (nums i) (nums (- i %))) 3) js)]
            (apply + (map #(solver (- i %)) js'))))))))
(defn- count-combinations [nums]
  (let [solver (count-combinations-solver nums)]
    (solver (dec (count nums)))))
(defn part-2
  [in]
  (let [adapters (parse in)]
    (count-combinations adapters)))
