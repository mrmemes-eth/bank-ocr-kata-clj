(ns bank-ocr.interpreter-test
  (:require [clojure.test :refer :all]
            [bank-ocr.interpreter :refer :all]))

(deftest matrix-to-digit-conversion
  (are [matrix digit] (= (matrix->digit matrix) digit)
        zero   0
        one    1
        two    2
        three  3
        four   4
        five   5
        six    6
        seven  7
        eight  8
        nine   9))

(deftest verify-matrices-to-account-number-string-conversion
  (are [account-number matrices]
       (= (matrices->account-number matrices) account-number)
       "000000000" [zero zero zero zero zero zero zero zero zero]
       "111111111" [one one one one one one one one one]
       "222222222" [two two two two two two two two two]
       "333333333" [three three three three three three three three three]
       "444444444" [four four four four four four four four four]
       "555555555" [five five five five five five five five five]
       "666666666" [six six six six six six six six six]
       "777777777" [seven seven seven seven seven seven seven seven seven]
       "888888888" [eight eight eight eight eight eight eight eight eight]
       "999999999" [nine nine nine nine nine nine nine nine nine]
       "123456789" [one two three four five six seven eight nine]))
