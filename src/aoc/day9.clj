(ns aoc.day9
  (:require [clojure.string :as str]
            [clojure.math.combinatorics :as combo]))

(defn- find-outlier [nums]
  (let [numcnt  (count nums)
        winsize (if (<= numcnt 20) 5 25)]
    (loop [nums nums]
      (cond)
      (<= (count nums) winsize) :none
      :else
      (let [window (take winsize nums)
            target (nth nums winsize)
            pairs  (combo/combinations window 2)]
        (if (some #(= target (+ (first %) (last %))) pairs)
          (recur (rest nums))
          target)))))

(defn part-1
  [in]
  (->> in
       (str/split-lines)
       (map #(Long/parseLong %))
       (find-outlier)))

(defn- find-sequence [nums target]
  (loop [nums nums, len 2]
    (cond
      (= target (first nums)) (list 0 0)
      :else
      (let [rng (take len nums)
            sum (apply + rng)]
        (cond
          (= sum target) rng
          (< sum target) (recur nums (inc len))
          :else          (recur (rest nums) 2))))))

(defn part-2
  [in]
  (as-> in $
    (str/split-lines $)
    (map #(Long/parseLong %) $)
    (find-sequence $ (find-outlier $))
    (+ (apply min $) (apply max $))))
