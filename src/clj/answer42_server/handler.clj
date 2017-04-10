(ns answer42-server.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [answer42-server.routes.services :refer [service-routes]]
            [compojure.route :as route]
            [answer42-server.env :refer [defaults]]
            [mount.core :as mount]
            [answer42-server.middleware :as middleware]))

(mount/defstate init-app
                :start ((or (:init defaults) identity))
                :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
    #'service-routes
    (route/not-found
      "page not found")))


(defn app [] (middleware/wrap-base #'app-routes))
