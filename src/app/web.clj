(ns app.web
  (:use ring.adapter.jetty))

(defn ip [request]
  (or ((:headers request) "x-forwarded-for")
      (:remote-addr request)))

(defn json? [request]
  (let [accept-hdr ((:headers request) "accept")]
  (cond
    (= accept-hdr "application/json") true
    (= "pathname" "/.json") true
    :else false)))

(defn app [req]
  (let [remote-addr (ip req)]
  (cond
    (= (json? req) true) (let [mybody (str "ip:" remote-addr))
    :else (let [mybody remote-addr])
  ;(let [mybody (str "ip: " remote-addr)]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body mybody
  })))

(defn -main []
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "5000"))]
    (run-jetty app {:port port})))

