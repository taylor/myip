(ns app.web
  (:use ring.adapter.jetty))

(defn ip [request]
  (or ((:headers request) "x-forwarded-for")
      (:remote-addr request)))

(defn json? [request]
  (let [accept-hdr (:headers request) "accept"]
  (or (
      (== accept-hdr "application/json") 
      (== "pathname" "/.json")
        true false))))

(defn app [req]
  (let [remote-addr (ip req)]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body (str "ip:" (remote-addr))}))
;   :body "ip:" + ip {req}})

(defn -main []
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "5000"))]
    (run-jetty app {:port port})))

