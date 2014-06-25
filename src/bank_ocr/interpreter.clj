(ns bank-ocr.interpreter
  (:require [clojure.string :refer [join]]))

(def zero
  [[" _ "]
   ["| |"]
   ["|_|"]])

(def one
  [["   "]
   ["  |"]
   ["  |"]])

(def two
  [[" _ "]
   [" _|"]
   ["|_ "]])

(def three
  [[" _ "]
   [" _|"]
   [" _|"]])

(def four
  [["   "]
   ["|_|"]
   ["  |"]])

(def five
  [[" _ "]
   ["|_ "]
   [" _|"]])

(def six
  [[" _ "]
   ["|_ "]
   ["|_|"]])

(def seven
  [[" _ "]
   ["  |"]
   ["  |"]])

(def eight
  [[" _ "]
   ["|_|"]
   ["|_|"]])

(def nine
  [[" _ "]
   ["|_|"]
   [" _|"]])

(def digits
  {zero 0 one  1 two   2 three 3 four 4
   five 5 six  6 seven 7 eight 8 nine 9})

(defn matrix->digit [matrix]
  (get digits matrix))
