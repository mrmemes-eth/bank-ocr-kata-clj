(ns bank-ocr.interpreter-test
  (:require [clojure.test :refer :all]
            [bank-ocr.interpreter :refer :all]))

(defascii ill
  "  |"
  "  |"
  "  |")

(deftest matrix-to-digit-conversion
  (are [matrix digit] (= digit (matrix->digit matrix))
        zero   0
        one    1
        two    2
        three  3
        four   4
        five   5
        six    6
        seven  7
        eight  8
        nine   9
        ill   "?"))

(deftest verify-matrices-to-account-number-string-conversion
  (are [account-number matrices]
       (= (matrices->account-number matrices) account-number)
       [0 0 0 0 0 0 0 0 0] [zero zero zero zero zero zero zero zero zero]
       [1 1 1 1 1 1 1 1 1] [one one one one one one one one one]
       [2 2 2 2 2 2 2 2 2] [two two two two two two two two two]
       [3 3 3 3 3 3 3 3 3] [three three three three three three three three three]
       [4 4 4 4 4 4 4 4 4] [four four four four four four four four four]
       [5 5 5 5 5 5 5 5 5] [five five five five five five five five five]
       [6 6 6 6 6 6 6 6 6] [six six six six six six six six six]
       [7 7 7 7 7 7 7 7 7] [seven seven seven seven seven seven seven seven seven]
       [8 8 8 8 8 8 8 8 8] [eight eight eight eight eight eight eight eight eight]
       [9 9 9 9 9 9 9 9 9] [nine nine nine nine nine nine nine nine nine]
       [1 2 3 4 5 6 7 8 9] [one two three four five six seven eight nine]))
