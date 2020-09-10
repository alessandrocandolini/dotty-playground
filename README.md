# Dotty playground 

sbt toy project to experiment with [Dotty](https://dotty.epfl.ch/), as well as to get an understanding of the current status of the compatibility of the Scala ecosystem (libraries, IDEs, etc) with Dotty.  

## The toy project 

HTTP REST server for a simple calendar app, exposing endpoints to create and retrieve calendar events of a given user. Acceptance criteria include authentication, authorisation (aka, permissions), validation (field validation & check that there are no other overlapping calendar events), etc. Despite the simplicity, these few requirements already allow us to explore some of the Dotty capabilities

## The setup 

* Latest version of Dotty is `0.0.27-RC1` but `zio` is only published for `0.0.26-RC1`, so we will use `0.0.26-RC1` for now 
* build tool: sbt `1.3.13` (latest `1.3.x` series), nothing fancy here; sbt `1.14.0-RC1` seems to be not stable enough yet (eg, it does not accept `@main`, there are problems with cache invalidation, etc)
* to expose the endpoints and generate documentation we use [tapir](https://github.com/softwaremill/tapir) (although it's not released for dotty yet, but the version for scala `2.13` seems working) 
* to describe effects, we use [zio](https://github.com/zio/zio)





