(ns find-interesting-links.core
  (:require [clojure.data.json :as json]) 
  (:require [clojure.java.jdbc :as sql])
  )

(def db
  {:classname   "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname     "/Users/poepping/experiments/clojure_experiments/find-interesting-links/links.db"})

(defn top-stories []
  (json/read-str (slurp "https://hacker-news.firebaseio.com/v0/topstories.json"))
  )

(defn insert_link [link]
  (sql/insert! db :links {:url link :links "" :words ""})
  )

(defn url-exists? [url]
  (> (count (sql/query db (str "select url from links where url='" url "'"))) 0 )
)

(defn getdb []
  (sql/query db (str "select * from links"))
)

(defn get-url [id]
  (let [url (str "https://hacker-news.firebaseio.com/v0/item/" id ".json")]
    (get (json/read-str (slurp url)) "url")
    )
  )

(defn top-500-url []
  (map insert_link (remove url-exists? (remove nil? (map get-url (top-stories))) ))
  )

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
