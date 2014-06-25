(ns bank-ocr.interpreter-test
  (:require [clojure.test :refer :all]
            [bank-ocr.interpreter :refer :all]))

;; verify matrix to digit conversion
(is (= 0 (matrix->digit zero)))
(is (= 1 (matrix->digit one)))
(is (= 2 (matrix->digit two)))
(is (= 3 (matrix->digit three)))
(is (= 4 (matrix->digit four)))
(is (= 5 (matrix->digit five)))
(is (= 6 (matrix->digit six)))
(is (= 7 (matrix->digit seven)))
(is (= 8 (matrix->digit eight)))
(is (= 9 (matrix->digit nine)))

;; verify matrices to account number conversion

(is (=
     (matrices->account-number [zero zero zero zero zero zero zero zero zero])
     "000000000"))

(is (=
     (matrices->account-number [one one one one one one one one one])
     "111111111"))

(is (=
     (matrices->account-number [two two two two two two two two two])
     "222222222"))

(is (=
     (matrices->account-number [three three three three three three three three three])
     "333333333"))

(is (=
     (matrices->account-number [four four four four four four four four four])
     "444444444"))

(is (=
     (matrices->account-number [five five five five five five five five five])
     "555555555"))

(is (=
     (matrices->account-number [six six six six six six six six six])
     "666666666"))

(is (=
     (matrices->account-number [seven seven seven seven seven seven seven seven seven])
     "777777777"))

(is (=
     (matrices->account-number [eight eight eight eight eight eight eight eight eight])
     "888888888"))

(is (=
     (matrices->account-number [nine nine nine nine nine nine nine nine nine])
     "999999999"))

(is (=
     (matrices->account-number [one two three four five six seven eight nine])
     "123456789"))
