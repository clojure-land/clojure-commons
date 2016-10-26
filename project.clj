(defproject marick/clojure-commons "3.0.0"
  :description "A commons.clojure.core to :use everywhere"
  :url "https://github.com/marick/clojure-commons"
  :pedantic? :warn
  :license {:name "The MIT License (MIT)"
            :url "http://opensource.org/licenses/mit-license.php"
            :distribution :repo}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [swiss-arrows "1.0.0" :exclusions [org.clojure/clojure]]
                 [marick/suchwow "6.0.0" :exclusions [org.clojure/clojure]]
                 [slingshot "0.12.2"]]

  :repl-options {:init (do (require 'commons.doc)
                          ;; List available api docs on repl startup:
                          (such.doc/apis))}

  :profiles {:dev {:dependencies [[midje "1.9.0-alpha5" :exclusions [org.clojure/clojure]]]}
             :1.7 {:dependencies [[org.clojure/clojure "1.7.0"]]}
             :1.8 {:dependencies [[org.clojure/clojure "1.8.0"]]}
             :1.9 {:dependencies [[org.clojure/clojure "1.9.0-alpha10"]]}
             }

  :plugins [[lein-midje "3.1.3"]
            [codox "0.8.11"]]

  :codox {:src-dir-uri "https://github.com/marick/clojure-commons/blob/master/"
          :src-linenum-anchor-prefix "L"
          :output-dir "/var/tmp/clojure-commons-doc"
          :defaults {:doc/format :markdown}}

  :aliases {"compatibility" ["with-profile" "+1.7:+1.8:+1.9" "midje" ":config" ".compatibility-test-config"]
            "travis" ["with-profile" "+1.7:+1.8:+1.9" "midje"]}

  ;; For Clojure snapshots
  :repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"}
  :deploy-repositories [["releases" :clojars]]
)
