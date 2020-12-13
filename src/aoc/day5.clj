(ns aoc.day5
  (:require [aoc.util :refer :all]
            [clojure.string :as str]))

(defn- bin-partition
  [ch [l h]]
  (let [gap (/ (+ l h 1) 2)]
    (cond (or (= \F ch) (= \L ch))
          (vector l (dec gap))
          :else
          (vector gap h))))
(defn- recur-partitions
  [s [l h]]
  (loop [s' s l' l h' h]
    (if (= h' l')
      h'
      (let [res (bin-partition (get s' 0) [l' h'])]
        (recur (subs s' 1) (get res 0) (get res 1))))))
(defn- get-seat
  [s [l h]]
  (let [row (recur-partitions (subs s 0 7) [l h])
        col (recur-partitions (subs s 7) [0 7])]
    (+ col (* row 8))))
(defn part-1
  [in]
  (->> in
       (str/split-lines)
       (map #(get-seat % [0 127]))
       (apply max)))

(defn part-2
  [in]
  (->> in
       (str/split-lines)
       (map #(get-seat % [0 127]))
       (sort)
       (drop 8)
       (reverse)
       (drop 8)
       (reverse)
       (partition 3 1)
       (filter #(not= (inc (nth % 0)) (nth % 1) (dec (nth % 2))))))
