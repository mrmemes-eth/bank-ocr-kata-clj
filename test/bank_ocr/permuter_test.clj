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
       [nine, four]      ninish
       [seven]           sevenish
       [six, nine, zero] eight))

