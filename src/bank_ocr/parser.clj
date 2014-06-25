(ns bank-ocr.parser)

(defn parse [ocr-text]
  (map #(re-seq #"." %)
       (clojure.string/split ocr-text #"\n")))

(defn matrices [parsed]
  (apply mapv vector (map #(partition 3 %) parsed)))
