(ns bank-ocr.interpreter)

(defmacro defascii [number-name & ascii]
  `(def ~number-name (map #(re-seq #"." %) '~ascii)))

(defascii zero
  " _ "
  "| |"
  "|_|")

(defascii one
  "   "
  "  |"
  "  |")

(defascii two
  " _ "
  " _|"
  "|_ ")

(defascii three
  " _ "
  " _|"
  " _|")

(defascii four
  "   "
  "|_|"
  "  |")

(defascii five
  " _ "
  "|_ "
  " _|")

(defascii six
  " _ "
  "|_ "
  "|_|")

(defascii seven
  " _ "
  "  |"
  "  |")

(defascii eight
  " _ "
  "|_|"
  "|_|")

(defascii nine
  " _ "
  "|_|"
  " _|")

(def digits
  {zero 0 one  1 two   2 three 3 four 4
   five 5 six  6 seven 7 eight 8 nine 9})

(defn matrix->digit [matrix]
  (get digits matrix))

(defn matrices->account-number [matrices]
  (apply str (map matrix->digit matrices)))
