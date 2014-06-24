(defproject bank_ocr "0.1.0-SNAPSHOT"
  :description "Bank OCR Kata"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :profiles  {:dev  {:injections  [(require 'pjstadig.humane-test-output)
                                   (pjstadig.humane-test-output/activate!)]
                     :resource-paths ["fixtures"]
                     :dependencies [[pjstadig/humane-test-output  "0.6.0"]]}}
  :dependencies [[org.clojure/clojure "1.5.1"]])
