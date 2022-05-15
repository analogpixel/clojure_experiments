(require 'cljs.build.api)
(cljs.build.api/watch
 "src"
  {:main 'cljs-my-project.core
   :output-to "out/main.js"
   }
   )
