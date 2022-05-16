default:
  just --list

alias b := build
alias r := repl

help:
  clj -M -m figwheel.main --help

repl:
  clojure -M -m figwheel.main --optimizations none --watch src --compile hello.world --repl

build:
  clojure -M -m figwheel.main --optimizations advanced --build-once world
