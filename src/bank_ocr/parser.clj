(ns bank-ocr.parser
  (:require [clojure.string :as string]))

(defn split [path]
  (string/split (slurp path) #"\n\n"))

(defn parse [ocr-text]
  (string/split-lines ocr-text))

(defn matrices [parsed]
  (apply map list (map (partial partition 3) parsed)))
