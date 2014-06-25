(ns bank-ocr.parser-test
  (:require [clojure.test :refer :all]
            [bank-ocr.parser :refer :all]))

(def zero-to-nine (slurp "fixtures/one_to_nine.txt"))
(def parsed (parse zero-to-nine))

(deftest verify-parse-shape
  (is (= 3 (count parsed)))
  (is (= 27 (count (first parsed)))))

(deftest verify-matrices-shape
  (is (= 9 (count (matrices parsed))))
  (is (= 3 (count (first (matrices parsed)))))
  (is (= 3 (count (first (first (matrices parsed)))))))
