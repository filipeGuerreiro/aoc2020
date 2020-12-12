(ns aoc.day4
  (:require [clojure.string :as str]
            [clojure.edn :as edn]))
(defn spy
  [& args]
  (apply prn args)
  (last args))

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

(defn- valid-passport-1
  [p]
  (and (contains? p :byr)
       (contains? p :iyr)
       (contains? p :eyr)
       (contains? p :hgt)
       (contains? p :hcl)
       (contains? p :ecl)
       (contains? p :pid)))
(defn part-1
  [in]
  (let [passports (parse in)]
    (->> passports
         (filter #(valid-passport-1 %))
         (count))))

(defn- valid-height? [height]
  (let [[_ val unit] (re-find #"(\d+)(\w+)" (or height "0cm"))
        hgt (Integer/parseInt val)]
    (cond
      (= unit "cm") (<= 150 hgt 193)
      (= unit "in") (<= 59 hgt 76)
      :else         false)))
(defn- valid-hair? [hair]
  (re-matches #"^#[0-9a-f]{6}$" (or hair "")))
(defn- valid-eyes? [eyes]
  (some? (#{"amb" "blu" "brn" "gry" "grn" "hzl" "oth"} eyes)))
(defn- valid-pid? [pid]
  (re-matches #"^\d{9}$" (or pid "")))
(defn- valid-passport-2
  [p]
  (let [{byr :byr
         iyr :iyr
         eyr :eyr
         hgt :hgt
         hcl :hcl
         ecl :ecl
         pid :pid} p]
    (and (<= 1920 (Integer/parseInt (or byr "0")) 2002)
         (<= 2010 (Integer/parseInt (or iyr "0")) 2020)
         (<= 2020 (Integer/parseInt (or eyr "0")) 2030)
         (valid-height? hgt)
         (valid-hair? hcl)
         (valid-eyes? ecl)
         (valid-pid? pid))))
(defn part-2
  [in]
  (let [passports (parse in)]
    (->> passports
         (filter #(valid-passport-2 %))
         (count))))
