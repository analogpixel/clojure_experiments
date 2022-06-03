(ns acme.frontend.app)

(defn init []
  (set! (.-innerHTML (.getElementById js/document "root")) "hello world")
  (println "Hello World"))
