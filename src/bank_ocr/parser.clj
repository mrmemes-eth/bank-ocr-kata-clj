(ns bank-ocr.parser
  (:require [clojure.string :refer [split-lines]]))

(defn parse [ocr-text]
  (map #(re-seq #"." %)
       (split-lines ocr-text)))

(defn matrices [parsed]
  (apply mapv vector (map #(partition 3 %) parsed)))
