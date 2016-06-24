(ns stream-to-mongo-clj.core
  [:require
    [clojure.string :as str]
    [clojure.java.io :as io]]
  (:gen-class))

(def config (atom {}))

(defn set-config [new-config]
  (reset! config new-config))

(set-config {:batch-size 2, :file-path "hello.txt"})

(defn read-file []
  (with-open [rdr (io/reader (:file-path @config))]
    (let [lines (line-seq rdr)]
      (read-batch lines))))

(defn read-batch [lines]
  (str/join " " (take (:batch-size @config) lines)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))