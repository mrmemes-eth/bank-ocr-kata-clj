(ns bank-ocr.parse)

(defn parse [ocr-text]
  (map #(re-seq #"." %)
       (clojure.string/split ocr-text #"\n")))
