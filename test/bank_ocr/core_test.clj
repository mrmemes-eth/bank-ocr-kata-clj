(ns bank-ocr.core-test
  (:require [clojure.test :refer :all]
            [bank-ocr.core :refer :all]
            [clojure.java.io :as io]))

(def expected-output
"000000000
111111111
222222222
333333333
444444444
555555555
666666666
777777777
888888888
999999999
123456789
")

(deftest test-output
  (is (= expected-output
       (with-out-str (-main (io/resource "ocr_account_numbers.txt"))))))

(def validated-output
"000000051
49006771? ILL
1234?678? ILL
664371495 ERR
")

(deftest test-validated-output
  (is (= validated-output
       (with-out-str (-validate (io/resource "user_story_3.txt"))))))
