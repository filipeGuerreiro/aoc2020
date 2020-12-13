(ns aoc.day7
  (:require [clojure.string :as str]
            [aoc.util :refer :all]))

(def bag "shiny gold")
(defn- parse-bag
  [line]
  (let [[[_ _ container] & elements] (re-seq #"(\d+)? ?(\w+ \w+) bags?" line)]
    {container (map (fn [[_ n color]]
                      (vector (Integer/parseInt n) color))
                    (filter (fn [[_ n _]] (some? n)) elements))}))
(defn- sub-contains?
  [container own-color bags]
  (->> container
       bags
       (some (fn [[n color]]
               (or (= color own-color)
                   (sub-contains? color own-color bags))))))
(defn part-1
  [in]
  (as-> in $
    (str/split-lines $)
    (map parse-bag $)
    (apply merge $)
    (filter (fn [[container els]]
              (sub-contains? container bag $)) $)
    (count $)))

(defn- sub-count
  [container bags]
  (->> container
       bags
       (reduce (fn [acc [n color]]
                 (+ acc n (* n (sub-count color bags))))
               0)))
(defn part-2
  [in]
  (->> in
       (str/split-lines)
       (map parse-bag)
       (apply merge)
       (sub-count bag)))
