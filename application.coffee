#!/usr/bin/env coffee

http = require "http"

http.createServer (request, response) ->

  if request.headers['accept'] is 'application/json'
    response.writeHead 200, 'Content-type': 'application/json'
    response.end "{'ip': '#{(request.headers['x-forwarded-for'] || request.connection.remoteAddress}'}"
  else
    response.writeHead 200, 'Content-type': 'text/plain'
    response.end request.headers['x-forwarded-for'] || request.connection.remoteAddress

  return

.listen process.env.PORT or 5000
