(ns aoc.day4
  (:require [clojure.string :as str]
            [clojure.edn :as edn]))

(defn- kv->edn
  [in]
  (let [[k v] (str/split in #":")]
    (str ":" k " " v)))
(defn- parse
  [in]
  (let [ss (str/split in #"\n\n")]
    (->> ss
         (map #(str/split % #" "))
         (map #(->> % println kv->edn))
         (map #(edn/read-string (str "{" % "}"))))))

(defn part-1
  [in]
  (parse in))

(defn part-2
  [in]
  in)
