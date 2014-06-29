(ns bank-ocr.permuter
  (:require [bank-ocr.interpreter :refer [digits]]))

(defn- transpose [tchar]
  (get {"_", " "
        " ", "_"
        "|", " "
        " ", "|"} tchar))

(defn permute [flat-matrix]
  (map-indexed #(assoc flat-matrix %1 (transpose %2)) flat-matrix))

(defn permutations [matrix]
  (->> matrix
       (flatten)
       (permute)
       ))
