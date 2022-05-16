(ns hn-spam-filter.core
  (:require [clojure.data.json :as json]) 
  )

(defn get-post [id] 
  (json/read-str
  (slurp (str "https://hacker-news.firebaseio.com/v0/item/" id ".json"))
  )
  )

(defn rp  []
  (json/read-str
    (slurp "https://hacker-news.firebaseio.com/v0/topstories.json")
    )
  )

(defn foo
  "I don't do a whole lot. (require 'hn-spam-filter.core :reload-all)"
  []
  (get-post (first (rp)))
  )
