(ns bank-ocr.parse-test
  (:require [clojure.test :refer :all]
            [bank-ocr.parse :refer :all]))

(def zero-to-nine (slurp "fixtures/one_to_nine.txt"))

(is (= 3 (count (parse zero-to-nine))))
(is (= 27 (count (first (parse zero-to-nine)))))
