(ns find-interesting-links.hnlinks
  (:require [clojure.data.json :as json]) 
  (:require [clojure.string :as str])
  (:require [clojure.java.shell :as sh])
  )


(def existing_links (set (map #(first (str/split %1 #",")) (str/split-lines (slurp "url-list.txt") ))))

(defn top-stories []
  (json/read-str (slurp "https://hacker-news.firebaseio.com/v0/topstories.json"))
  )

(defn get-url [id]
  (let [url (str "https://hacker-news.firebaseio.com/v0/item/" id ".json")]
    (get (json/read-str (slurp url)) "url")
    )
  )

(defn insert_link [url] 
  (sh/sh "/usr/bin/open" url)
  (println "Was that interesting y/n:")
  (let [yn (clojure.string/lower-case (read-line ))] 
    (cond 
      (= yn "y") (spit "url-list.txt" (str url ",1","\n") :append true)
      (= yn "n") (spit "url-list.txt" (str url ",0","\n") :append true)
      (= yn "q") (System/exit 0)
    )
  )
)

(defn url-exists? [url] 
  (contains? existing_links url)
  )

(defn top-500-url []
  (dorun (map insert_link (remove url-exists? (remove nil? (map get-url (top-stories))))) )
  )

(defn -main []
  (println "Starting")
  (top-500-url)
  )
