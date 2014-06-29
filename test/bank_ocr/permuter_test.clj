(ns bank-ocr.permuter-test
  (:require [clojure.test :refer :all]
            [bank-ocr.interpreter :refer [ascii]]
            [bank-ocr.permuter :refer :all]))

(def ninish (ascii
             "   "
             "|_|"
             " _|"))

(permute ninish)

(deftest permuting-known-chars
  (is (contains? [9] (permutations ninish))))


