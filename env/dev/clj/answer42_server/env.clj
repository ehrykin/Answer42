(ns answer42-server.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [answer42-server.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[answer42-server started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[answer42-server has shut down successfully]=-"))
   :middleware wrap-dev})
