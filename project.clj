(defproject fiumine "0.1.0-SNAPSHOT"
  :description "Simple web radio station written in Clojure."
  :url "https://github.com/chrisrossi/fiumine"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [me.raynes/conch "0.5.0"]
                 [marshal "1.0.0"]
                 [ring/ring-core "1.2.0"]
                 [ring/ring-jetty-adapter "1.2.0"]]
  :main fiumine.core)
