(ns app.core
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(def day1in
  (-> (io/resource "day1.in")
      slurp
      str/split-lines
      (->> (map #(Integer/parseInt %)))
      (into #{})))


(defn day1-1 [x]
  (->> day1-in
       (filter #(day1-in (- x %)))
       (map #(* (- x %) %))))

(def day1-2 [x]
  (->> day1-in
       ;; use part-1 to find 2 numbers that add up to (2020 - x)
       (filter #(day1-1 (- x %)))
       (map #(* % (- x %) (day1-1 (- x %))))))
