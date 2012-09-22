#!/usr/bin/env coffee

http = require "http"
url = require 'url'

http.createServer (request, response) ->
  if request.headers['accept'] == 'application/json' || url.parse(request.url).pathname == '.json'
    response.writeHead 200, 'Content-type': 'application/json'
    response.end "{'ip': '#{request.headers['x-forwarded-for'] || request.connection.remoteAddress}'}"
  else
    response.writeHead 200, 'Content-type': 'text/plain'
    #response.end request.headers['x-forwarded-for'] || request.connection.remoteAddress
    response.end "#{request.headers['x-forwarded-for'] || request.connection.remoteAddress} #{url.parse(request.url).pathname}"

  return

.listen process.env.PORT or 5000
