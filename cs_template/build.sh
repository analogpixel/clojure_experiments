if [ ! -f cljs.jar ] ; then
   wget https://github.com/clojure/clojurescript/releases/download/r1.11.4/cljs.jar
fi

java -cp cljs.jar:src clojure.main ./src/build.clj
