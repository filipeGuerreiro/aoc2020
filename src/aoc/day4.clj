(ns aoc.day4
  (:require [clojure.string :as str]
            [clojure.edn :as edn]))

(defn- kv->edn
  [in]
  (as-> in i
    (str/split i #" ")
    (map #(str ":" (str/replace % #":" " \"") "\"") i)
    (str/join " " i)))
(defn- parse
  [in]
  (as-> in i
    (str/split i #"\n\n")
    (map #(str/replace % #"\n" " ") i)
    (map #(kv->edn %) i)
    (map #(edn/read-string (str "{" % "}")) i)))

(defn part-1
  [in]
  (parse in))

(defn part-2
  [in]
  in)
