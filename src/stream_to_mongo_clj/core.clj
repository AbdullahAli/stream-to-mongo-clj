(ns stream-to-mongo-clj.core
  [:require
    [clojure.string]
    [clojure.java.io :as io]]
  (:gen-class))

(def batch-size 3)

; (def batch (atom []))

; (defn append-to-batch [doc]
;   (reset! batch (concat @batch [doc])))


; works but ugly
(defn read-file []
  (with-open [rdr (io/reader "hello.txt")]
    (let [lines (line-seq rdr)]
      (join " " (take batch-size lines)))))

; dont not work but nice
; (defn read-file []
;   (with-open [rdr (io/reader "hello.txt")]
;     (get-next-batch rdr)))
;
; (defn get-next-batch [rdr]
;   (let [lines (line-seq rdr)]
;     (take batch-size lines))))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))