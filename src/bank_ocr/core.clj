(ns bank-ocr.core
  (:require [bank-ocr.parser :as parser]
            [bank-ocr.interpreter :as interpreter]
            [bank-ocr.validator :as validator]
            [clojure.string :refer [split]]))

(defn- account-number-ocr->vector [ocr-account-number]
  (-> ocr-account-number
      (parser/parse)
      (parser/matrices)
      (interpreter/matrices->account-number)))

(defn validated-account-number [number-vector]
  (->> number-vector
       (validator/error-description)
       (conj number-vector)))

(defn -main [path]
  (doseq [ocr-account-number (split (slurp path) #"\n\n")]
    (->> ocr-account-number
         (account-number-ocr->vector)
         (apply str)
         (println))))

(defn -validate [path]
  (doseq [ocr-account-number (split (slurp path) #"\n\n")]
    (->> ocr-account-number
         (account-number-ocr->vector)
         (validated-account-number)
         (apply str)
         (println))))
