(ns aoc.day6
  (:require [clojure.string :as str]
            [aoc.util :refer :all]
            [clojure.set :as set]))

(defn part-1
  [in]
  (as-> in i
    (str/split i #"\n\n")
    (map #(str/replace % #"\n" "") i)
    (map #(count (distinct %)) i)
    (apply + i)))

(defn part-2
  [in]
  (as-> in i
    (str/split i #"\n\n")
    (map #(str/split % #"\n") i)
    (map #(map (fn [e] (set (char-array e))) %) i)
    (map #(apply set/intersection %) i)
    (map #(count %) i)
    (apply + i)))
