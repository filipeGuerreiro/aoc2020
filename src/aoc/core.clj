(ns aoc.core
  (:require [aoc.day1]
            [aoc.day2]
            [aoc.day3]
            [aoc.day4]
            ; [aoc.day5]
            ; [aoc.day6]
            ; [aoc.day7]
            ; [aoc.day8]
            ; [aoc.day9]
            ; [aoc.day10]
            ; [aoc.day11]
            ; [aoc.day12]
            ; [aoc.day13]
            ; [aoc.day14]
            ; [aoc.day15]
            ; [aoc.day16]
            ; [aoc.day17]
            ; [aoc.day18]
            ; [aoc.day19]
            ; [aoc.day20]
            ; [aoc.day21]
            ; [aoc.day22]
            ; [aoc.day23]
            ; [aoc.day24]
            ; [aoc.day25]
            ))

(defn read-input
  [day]
  (slurp (clojure.java.io/resource day)))

(defn -main
  "Used to dispatch tasks from the command line.

  lein run d1.p1"
  [part]
  (case part
    "d1.p1" (println (aoc.day1/part-1 (read-input "day1.in")))
    "d1.p2" (println (aoc.day1/part-2 (read-input "day1.in")))
    "d2.p1" (println (aoc.day2/part-1 (read-input "day2.in")))
    "d2.p2" (println (aoc.day2/part-2 (read-input "day2.in")))
    "d3.p1" (println (aoc.day3/part-1 (read-input "day3.in")))
    "d3.p2" (println (aoc.day3/part-2 (read-input "day3.in")))
    "d4.p1" (println (aoc.day4/part-1 (read-input "day4.in")))
    "d4.p2" (println (aoc.day4/part-2 (read-input "day4.in")))
                                        ; "d5.p1" (println (aoc.day5/part-1 (read-input "day5.in")))
                                        ; "d5.p2" (println (aoc.day5/part-2 (read-input "day5.in")))
                                        ; "d6.p1" (println (aoc.day6/part-1 (read-input "day6.in")))
                                        ; "d6.p2" (println (aoc.day6/part-2 (read-input "day6.in")))
                                        ; "d7.p1" (println (aoc.day7/part-1 (read-input "day7.in")))
                                        ; "d7.p2" (println (aoc.day7/part-2 (read-input "day7.in")))
                                        ; "d8.p1" (println (aoc.day8/part-1 (read-input "day8.in")))
                                        ; "d8.p2" (println (aoc.day8/part-2 (read-input "day8.in")))
                                        ; "d9.p1" (println (aoc.day9/part-1 (read-input "day9.in")))
                                        ; "d9.p2" (println (aoc.day9/part-2 (read-input "day9.in")))
                                        ; "d10.p1" (println (aoc.day10/part-1 (read-input "day10.in")))
                                        ; "d10.p2" (println (aoc.day10/part-2 (read-input "day10.in")))
                                        ; "d11.p1" (println (aoc.day11/part-1 (read-input "day11.in")))
                                        ; "d11.p2" (println (aoc.day11/part-2 (read-input "day11.in")))
                                        ; "d12.p1" (println (aoc.day12/part-1 (read-input "day12.in")))
                                        ; "d12.p2" (println (aoc.day12/part-2 (read-input "day12.in")))
                                        ; "d13.p1" (println (aoc.day13/part-1 (read-input "day13.in")))
                                        ; "d13.p2" (println (aoc.day13/part-2 (read-input "day13.in")))
                                        ; "d14.p1" (println (aoc.day14/part-1 (read-input "day14.in")))
                                        ; "d14.p2" (println (aoc.day14/part-2 (read-input "day14.in")))
                                        ; "d15.p1" (println (aoc.day15/part-1 (read-input "day15.in")))
                                        ; "d15.p2" (println (aoc.day15/part-2 (read-input "day15.in")))
                                        ; "d16.p1" (println (aoc.day16/part-1 (read-input "day16.in")))
                                        ; "d16.p2" (println (aoc.day16/part-2 (read-input "day16.in")))
                                        ; "d17.p1" (println (aoc.day17/part-1 (read-input "day17.in")))
                                        ; "d17.p2" (println (aoc.day17/part-2 (read-input "day17.in")))
                                        ; "d18.p1" (println (aoc.day18/part-1 (read-input "day18.in")))
                                        ; "d18.p2" (println (aoc.day18/part-2 (read-input "day18.in")))
                                        ; "d19.p1" (println (aoc.day19/part-1 (read-input "day19.in")))
                                        ; "d19.p2" (println (aoc.day19/part-2 (read-input "day19.in")))
                                        ; "d20.p1" (println (aoc.day20/part-1 (read-input "day20.in")))
                                        ; "d20.p2" (println (aoc.day20/part-2 (read-input "day20.in")))
                                        ; "d21.p1" (println (aoc.day21/part-1 (read-input "day21.in")))
                                        ; "d21.p2" (println (aoc.day21/part-2 (read-input "day21.in")))
                                        ; "d22.p1" (println (aoc.day22/part-1 (read-input "day22.in")))
                                        ; "d22.p2" (println (aoc.day22/part-2 (read-input "day22.in")))
                                        ; "d23.p1" (println (aoc.day23/part-1 (read-input "day23.in")))
                                        ; "d23.p2" (println (aoc.day23/part-2 (read-input "day23.in")))
                                        ; "d24.p1" (println (aoc.day24/part-1 (read-input "day24.in")))
                                        ; "d24.p2" (println (aoc.day24/part-2 (read-input "day24.in")))
                                        ; "d25.p1" (println (aoc.day25/part-1 (read-input "day25.in")))
                                        ; "d25.p2" (println (aoc.day25/part-2 (read-input "day25.in")))
    (println "not found")))
