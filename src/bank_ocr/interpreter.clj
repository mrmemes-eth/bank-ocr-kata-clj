(ns bank-ocr.interpreter)

(defn ascii [& lines]
  (map vec lines))


(def zero (ascii
           " _ "
           "| |"
           "|_|"))

(def one (ascii
          "   "
          "  |"
          "  |"))

(def two (ascii
          " _ "
          " _|"
          "|_ "))

(def three (ascii
            " _ "
            " _|"
            " _|"))

(def four (ascii
           "   "
           "|_|"
           "  |"))

(def five (ascii
           " _ "
           "|_ "
           " _|"))

(def six (ascii
          " _ "
          "|_ "
          "|_|"))

(def seven (ascii
            " _ "
            "  |"
            "  |"))

(def eight (ascii
            " _ "
            "|_|"
            "|_|"))

(def nine (ascii
           " _ "
           "|_|"
           " _|"))

(def digits
  { zero 0, one 1, two 2, three 3, four 4
    five 5, six 6, seven 7, eight 8, nine 9 })

(defn matrix->digit [matrix]
  (get digits matrix \?))

(defn matrices->account-number [matrices]
  (mapv matrix->digit matrices))
