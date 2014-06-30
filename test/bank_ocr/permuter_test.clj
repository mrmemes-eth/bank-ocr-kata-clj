(ns bank-ocr.permuter-test
  (:require [clojure.test :refer :all]
            [bank-ocr.interpreter :refer :all]
            [bank-ocr.permuter :refer :all]))

(def ninish (ascii
             "   "
             "|_|"
             " _|"))

(def sevenish (ascii
               " _ "
               "  |"
               "   "))

(deftest permuting-known-chars
  (are [perms matrix] (= perms (permutations matrix))
       [9,4]   ninish
       [7]     sevenish
       [0,6,9] eight))

