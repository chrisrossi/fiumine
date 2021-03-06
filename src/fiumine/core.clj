(ns fiumine.core
  "Simple music streamer."
  (:require [fiumine.publisher :as pub]
            [fiumine.service :as service]
            [fiumine.station :as station]
            [fiumine.utils :as utils])
  (:gen-class))

(def audio-file-extensions #{".flac" ".ogg" ".mp3"})

(defn audio-file?
  "Returns true if file's extension matches a known audio type."
  [file]
  (contains? audio-file-extensions (utils/file-extension file)))

(defn get-audio-files
  "For a given folder find all the files that look like audio files."
  [folder]
  (filter audio-file? (file-seq folder)))

(defn -main
  [path port & args]
  (let [folder (clojure.java.io/file path)
        audio-files (cycle (shuffle (get-audio-files folder)))
        station (station/start-station audio-files)
        publisher (pub/publish-stream station)]
    (pub/start publisher)
    (service/start publisher (Integer/parseInt port))))
