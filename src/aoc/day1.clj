(ns aoc.day1
  (:require [clojure.string :as str]))

(defn seq->lazyi [in]
  (-> in
      str/split-lines
      (->> (map #(Integer/parseInt %)))))

(def x 2020)

(defn- part-1-seq [in x]
  (let [memo (into #{} (seq->lazyi in))]
    (->> memo
         (filter #(memo (- x %))))))
(defn part-1 [in]
  (->> (part-1-seq in x)
       (map #(* (- x %) %))
       first))

(defn part-2 [in]
  (let [p1 (into #{} (part-1-seq in x))]
    (->> (seq->lazyi in)
         ;; use part-1 to find 2 numbers that add up to (2020 - i)
         (filter #(p1 (- x %)))
         (map #(* % (- x %) (p1 (- x %))))
         first)))
