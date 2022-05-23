(defproject find-interesting-links "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                [org.clojure/data.json "2.4.0"] 
                [org.clojure/java.jdbc "0.7.5"]
                [org.xerial/sqlite-jdbc "3.7.2"]
                 ]
  :repl-options {:init-ns find-interesting-links.core}
  :main find-interesting-links.hnlinks
  )
