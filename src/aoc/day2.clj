(ns aoc.day2
  (:require [clojure.string :as str]))

(defn- get-lines [input]
  (str/split-lines input))
(defn- valid-password [line policy]
  (let [[r ch pw] (str/split line #" ")
        [lo hi]   (str/split r #"-")
        ch        (first ch)
        pwparts   (group-by identity (seq pw))
        num       (count (pwparts ch))]
    (policy pw ch num (Integer/parseInt hi) (Integer/parseInt lo))))
(defn- count-valid-lines
  [in policy]
  (->> in
       get-lines
       (filter #(valid-password % policy))
       (count)))

(defn- part-1-policy
  [pw ch num hi lo]
  (and (<= num hi) (>= num lo)))
(defn part-1
  [in]
  (count-valid-lines in part-1-policy))

(defn- part-2-policy
  [pw ch num hi lo]
  (let [pwparts (vec (seq pw))
        chlo    (= ch (pwparts (dec lo)))
        chhi    (= ch (pwparts (dec hi)))]
    (and (or chlo chhi)
         (not (and chlo chhi)))))
(defn part-2
  [in]
  (count-valid-lines in part-2-policy))
