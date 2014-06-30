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

(defn- validated-account-number [number-vector]
  (if-let [error-desc (validator/error-description number-vector)]
    (conj number-vector \space error-desc)
    number-vector))

(defn -main [path]
  (doseq [ocr-account-number (split (slurp path) #"\n\n")]
    (println (->> (account-number-ocr->vector ocr-account-number)
                  (apply str)))))

(defn -validate [path]
  (doseq [ocr-account-number (split (slurp path) #"\n\n")]
    (println (->> (account-number-ocr->vector ocr-account-number)
                  (validated-account-number)
                  (apply str)))))
