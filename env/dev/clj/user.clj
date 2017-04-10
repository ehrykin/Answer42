(ns user
  (:require [mount.core :as mount]
            answer42-server.core))

(defn start []
  (mount/start-without #'answer42-server.core/repl-server))

(defn stop []
  (mount/stop-except #'answer42-server.core/repl-server))

(defn restart []
  (stop)
  (start))


