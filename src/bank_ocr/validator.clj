(ns bank-ocr.validator)

(defn checksum [account-number-vector]
  (->> (reverse account-number-vector)
       (map-indexed #(* (inc %1) %2))
       (reduce +)))

(defn valid? [account-number-vector]
  (and
   (not (some #{"?"} account-number-vector))
   (-> (checksum account-number-vector)
       (mod 11)
       (= 0))))
