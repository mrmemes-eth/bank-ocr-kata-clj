(ns bank-ocr.parser
  (:require [clojure.string :refer [split]]))

(defn parse [ocr-text]
  (map #(re-seq #"." %)
       (split ocr-text #"\n")))

(defn matrices [parsed]
  (apply mapv vector (map #(partition 3 %) parsed)))
