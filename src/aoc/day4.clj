(ns aoc.day4
  (:require [clojure.string :as str]
            [clojure.edn :as edn]))

(defn- kv->edn
  [in]
  (let [[k v] (str/split in #":")]
    (str ":" k " " v)))
(defn- parse
  [in]
  (as-> in i
    (str/split i #"\n\n")
    (map #(str/replace % #"\n" " ") i)
    (map #(kv->edn %) i)
    (map #(edn/read-string (str "{" % "}")) i)))
                                        ;println)))
                                        ; (map #(-> %
                                        ;          (str/split #" "))))

;;println
;;(->> (map #(kv->edn (println %))))
;;(map #(edn/read-string (str "{" % "}"))))))

(defn part-1
[in]
(parse in))

(defn part-2
[in]
in)
