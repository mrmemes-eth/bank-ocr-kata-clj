# Bank OCR kata in clojure

Implementation of the Bank OCR kata in clojure

Program output can be viewed using Leiningen, e.g.:

`lein run path/to/file.ext`

Specifically:

`lein run fixtures/ocr_account_numbers.txt`

To run the converter with validation output use:

`lein run -m bank-ocr.core/-validate path/to/file.ext`

## License

See LICENSE
