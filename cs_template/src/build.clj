(require 'cljs.build.api)
(cljs.build.api/build
 "src"
  {:main 'cljs-my-project.core
   :output-to "out/main.js"
   }
   )
