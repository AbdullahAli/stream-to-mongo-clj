(ns stream-to-mongo-clj.core
  [:require
    [clojure.string :as str]
    [clojure.java.io :as io]]
  (:gen-class))

(def config (atom {}))

(defn set-config [new-config]
  (reset! config new-config))

(set-config {:batch-size 2, :file-path "hello.txt"})

(defn read-batch [lines]
  (println (str/join " " lines)))

(defn do-something-interesting [batch]
  (println batch))

(defn read-file []
  (with-open [reader (io/reader (:file-path @config))]
    (->> (line-seq reader)
      (partition-all (:batch-size @config))
      (#(doseq [batch %]
          (do-something-interesting batch))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))