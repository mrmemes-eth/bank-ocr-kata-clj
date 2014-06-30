(ns bank-ocr.permuter
  (:require [bank-ocr.interpreter :refer [digits]]))

(defn- transpose-pipe [tchar]
  (get {"|" " ", " " "|"} tchar))

(defn- transpose-underscore [tchar]
  (get {"_" " ", " " "_"} tchar))

(defn- permute-pipe [flat-matrix]
  (map-indexed #(assoc flat-matrix %1 (transpose-pipe %2)) flat-matrix))

(defn- permute-underscore [flat-matrix]
  (map-indexed #(assoc flat-matrix %1 (transpose-underscore %2)) flat-matrix))

(defn permute [flat-matrix]
  (concat (permute-underscore flat-matrix) (permute-pipe flat-matrix)))

(defn permutations [matrix]
  (->> matrix
       (flatten)
       (vec)
       (permute)
       (map #(get digits (partition 3 %)))
       (filter (comp not nil?))))
