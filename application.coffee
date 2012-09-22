#!/usr/bin/env coffee

http = require "http"

http.createServer (request, response) ->

  response.writeHead 200, 'Content-type': 'text/plain'
  response.end request.headers.host
  #response.end request.connection.remoteAddress

  return

.listen process.env.PORT or 5000
