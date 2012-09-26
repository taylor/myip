(ns app.web
  (:use ring.adapter.jetty))

(defn ip [request]
  (or ((:headers request) "x-forwarded-for")
      (:remote-addr request)))

;(let [remote_ip (ip req))]

(defn app [req]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "test"})
;   :body "ip:" + ip {req}})

;  (let [port (Integer/parseInt (System/getenv "PORT"))]
(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (run-jetty app {:port port})))

