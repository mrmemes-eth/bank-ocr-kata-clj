(ns bank-ocr.permuter
  (:require [bank-ocr.interpreter :refer [digits]]))

(defn- transpose [transpose-character character]
  (get {transpose-character \space, \space transpose-character} character))

(defn- permute-char [char-vec character]
  (map-indexed #(assoc char-vec %1 (transpose character %2)) char-vec))

(defn- permute [char-vec]
  (mapcat #(permute-char char-vec %) [\| \_]))

(defn- char-vec->matrix [char-vec]
  (partition 3 char-vec))

(defn- valid-matrix? [matrix]
  (contains? digits matrix))

(defn permutations [matrix]
  (->> (vec (flatten matrix))
       (permute)
       (map char-vec->matrix)
       (filter valid-matrix?)))

