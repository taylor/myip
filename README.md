# Remote address aka what is my ip

This is a simple remote address displayer application written in *both* [Clojure](http://clojure.org/) (running on jetty) and [Coffescript](http://coffeescript.org) (running on [Node](http://nodejs.org) targetting [Heroku](http://heroku.com/).

Change the Procfile to try the different versions.


## Other languages

*Perl*

A  perl version just for fun (does not include redirect and forward support) though I may use the perl build pack https://github.com/miyagawa/heroku-buildpack-perl at some point.

The main thing with the current perl version is it works on any system that
supports CGI as-is w/stock a stock perl install.

*Ruby*

I'll probably not include this because well it feels too easy :)  Try the one listed in this blog post http://blog.jerodsanto.net/2009/05/3-reasons-why-heroku-is-a-game-changer/

*Java*

Haha

*PHP*

mmmm.  No.

But if *you* want it you can basically use the Perl version...

*???*

Fork and contribute a new one.

I should probably make language sub dirs or something...

---

Adapated from
  * Heroku's ["Getting Started With Node.js on Heroku/Cedar."](http://devcenter.heroku.com/articles/node-js)
  * ["Flesch's coffeescript starter template."](https://github.com/flesch/coffeescript-on-heroku)
  * And some clojure sites...
