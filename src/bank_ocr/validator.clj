(ns bank-ocr.validator)

(defn checksum [account-number-vector]
  (->> (reverse account-number-vector)
       (map-indexed #(* (inc %1) %2))
       (reduce +)))

(defn legible? [account-number-vector]
  (not (contains? (set account-number-vector) \?)))

(defn valid? [account-number-vector]
  (and
   (legible? account-number-vector)
   (-> (checksum account-number-vector)
       (mod 11)
       (= 0))))

(defn error-description [account-number-vector]
  (cond (not (legible? account-number-vector)) "ILL"
        (not (valid? account-number-vector)) "ERR"))

