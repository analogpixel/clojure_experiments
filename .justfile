default:
  just --list

alias r := new_react_cs

new_react_cs dir="":
  clj -Tclj-new create :template figwheel-main :name yourname/{{ dir }} :args '["+npm-bundle","--react", "+deps"]'
