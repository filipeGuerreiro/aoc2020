(ns aoc.day8
  (:require [clojure.string :as str]
            [aoc.util :refer :all]))

(defn- parse-line
  [i line]
  (let [[[_ ins v]] (re-seq #"(\w+) \+?(-?\d+)" line)]
    {:i i :ins ins :val (Integer/parseInt v)}))

:input "acc +1\njmp -3\nnop +3"
:output [{:ins "acc" :val 1} {:ins "jmp" :val -3} {:ins "nop" :val 3}]
(defn- code-str->vec
  [code]
  (->> code
       (str/split-lines)
       (map-indexed #(parse-line %1 %2))
       (into [])))

:input {:ins "acc" :val 1}
:output {:add 1 :jmp 1}
(defn- calc-next
  [{ins :ins, v :val}]
  (case ins
    "acc" {:add v :jmp 1}
    "jmp" {:add 0 :jmp v}
    "nop" {:add 0 :jmp 1}))

:input [{:ins "acc" :val 1} {:ins "jmp" :val -3} {:ins "nop" :val 3}]
:output {:success true, :acc 3021, :execd #{1, 2, 6, 4, 8}}
(defn- run-code
  [code]
  (loop [i 0, acc 0, exec-code #{}]
    (let [looped (contains? exec-code i)]
      (if (or (= (+ i 1) (count code))
              looped)
        {:success (not looped), :acc acc, :execd exec-code}
        (let [{a :add, j :jmp} (calc-next (get code i))]
          (recur (+ i j) (+ acc a) (conj exec-code i)))))))

(def test-in
  "nop +0
acc +1
jmp +4
acc +3
jmp -3
acc -99
acc +1
jmp -4
acc +6")

:input "acc +1\njmp -3\nnop +3"
:output 1
(defn part-1
  [in]
  (->> in
       (code-str->vec)
       (run-code)
       (:acc)))

(defn- run-mod-code
  [code]
  (let [{success :success, acc :acc, execd :execd} (run-code code)
        jmps-or-nops (filter #(let [ins ((get code %) :ins)]
                                (or (= "jmp" ins) (= "nop" ins)))
                             execd)]
    (loop [success' success, acc' acc, jmps-or-nops' jmps-or-nops]
      (if (true? success')
        acc'
        (let [line (code (first jmps-or-nops'))
              mod-line (if (= "jmp" (line :ins))
                         (update line :ins (fn [_] "nop"))
                         (update line :ins (fn [_] "jmp")))
              code' (assoc code (first jmps-or-nops') mod-line)
              {success'' :success, acc'' :acc} (run-code code')]
          (recur success'' acc'' (rest jmps-or-nops')))))))
(defn part-2
  [in]
  (->> in
       (code-str->vec)
       (run-mod-code)))
