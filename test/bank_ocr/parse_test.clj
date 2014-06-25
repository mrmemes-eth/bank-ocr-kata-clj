(ns bank-ocr.parse-test
  (:require [clojure.test :refer :all]
            [bank-ocr.parse :refer :all]))

(def zero-to-nine (slurp "fixtures/one_to_nine.txt"))

;; parse
;; verifying the shape is 3x27; 3 rows of 27 characters
(is (= 3 (count (parse zero-to-nine))))
(is (= 27 (count (first (parse zero-to-nine)))))

;; matrices
;; verifying the shape is 9x3x3; 9 3x3 character matrices
(is (= 9 (count (matrices (parse zero-to-nine)))))
(is (= 3 (count (first (matrices (parse zero-to-nine))))))
(is (= 3 (count (first (first (matrices (parse zero-to-nine)))))))
