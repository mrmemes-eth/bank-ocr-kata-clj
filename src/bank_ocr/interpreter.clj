(ns bank-ocr.interpreter)

(defn ascii [& lines]
  (mapv #(re-seq #"." %) lines))


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
  (-> {}
      (assoc zero 0)
      (assoc one 1)
      (assoc two 2)
      (assoc three 3)
      (assoc four 4)
      (assoc five 5)
      (assoc six 6)
      (assoc seven 7)
      (assoc eight 8)
      (assoc nine 9)))

(defn matrix->digit [matrix]
  (get digits matrix "?"))

(defn matrices->account-number [matrices]
  (vec (map matrix->digit matrices)))
