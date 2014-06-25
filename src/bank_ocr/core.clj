(ns bank-ocr.core
  (:require [bank-ocr.parser :as parser]
            [bank-ocr.interpreter :as interpreter]
            [clojure.string :refer [split join]]))

(defn -main [path]
  (doseq [ocr-account-number (split (slurp path) #"\n\n")]
    (println (-> ocr-account-number
                 (parser/parse)
                 (parser/matrices)
                 (interpreter/matrices->account-number)))))
