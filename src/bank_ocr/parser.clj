(ns bank-ocr.parser
  (:require [clojure.string :refer [split-lines]]))

(defn parse [ocr-text]
  (split-lines ocr-text))

(defn matrices [parsed]
  (apply map list (map (partial partition 3) parsed)))
