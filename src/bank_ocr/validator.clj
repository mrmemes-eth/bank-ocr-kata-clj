(ns bank-ocr.validator)

(defn checksum [account-number-vec]
  (reduce + (map-indexed #(* (inc %1) %2) (reverse account-number-vec))))
