(ns bank-ocr.permuter
  (:require [bank-ocr.interpreter :refer [digits]]))

(defn- transpose [tchar c]
  (get {tchar " ", " " tchar} c))

(defn- permute-with [f flat-matrix]
  (map-indexed #(assoc flat-matrix %1 (f %2)) flat-matrix))

(defn permute [flat-matrix]
  (apply concat (map #(permute-with (partial transpose %) flat-matrix) ["|" "_"])))

(defn permutations [matrix]
  (->> matrix
       (flatten)
       (vec)
       (permute)
       (map #(get digits (partition 3 %)))
       (filter (comp not nil?))))
