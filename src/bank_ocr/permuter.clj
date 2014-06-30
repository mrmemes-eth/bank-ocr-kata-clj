(ns bank-ocr.permuter
  (:require [bank-ocr.interpreter :refer [digits]]))

(defn- matrix->flat-matrix [matrix]
  (vec (flatten matrix)))

(defn- transpose [transpose-character character]
  (get {transpose-character " ", " " transpose-character} character))

(defn- permute-char [flat-matrix character]
  (map-indexed #(assoc flat-matrix %1 (transpose character %2)) flat-matrix))

(defn- flat-matrix->digit [flat-matrix]
  (get digits (partition 3 flat-matrix)))

(defn- permute [flat-matrix]
  (mapcat #(permute-char flat-matrix %) ["|" "_"]))

(defn permutations [matrix]
  (->> matrix
       (matrix->flat-matrix)
       (permute)
       (map flat-matrix->digit)
       (filter (comp not nil?))))
