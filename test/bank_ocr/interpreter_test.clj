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
