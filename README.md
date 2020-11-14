# Dotty playground 

sbt toy project to experiment with [Dotty](https://dotty.epfl.ch/), as well as to get an understanding of the current status of the compatibility of the Scala ecosystem (libraries, IDEs, etc) with Dotty.  

## The toy project 

The plan is to build a toy rest api backend.

Don't take this project as an example of production-ready code: sometimes eg custom type classes (like Ord) are defined inside the code, instead of relying on built-in ones, just for fun and to explore the Dotty syntax in a simplified setting. 

## Dependencies 

* [dotty](https://dotty.epfl.ch/) `3.0.0-M1` (latest attow) 
* [sbt-dotty plugin](https://github.com/lampepfl/dotty/tree/master/sbt-dotty) `v0.4.6` (latest attow)
* [sbt](https://github.com/sbt/sbt) `1.4.2` (latest attow) 
* [ZIO](https://github.com/zio/zio) `1.0.3` (latest attow) is only published for dotty `0.0.27-RC1` so ZIO for scala 2.13 is currently used via `withDottyCompat`
* [circe](https://github.com/circe/circe) `0.14.0-M1` (latest attow) is only published for for dotty `0.0.27-RC1`
* [tapir](https://github.com/softwaremill/tapir) is not published for dotty yet
* [scalacheck](https://www.scalacheck.org/) `1.5.1` (latest attow) 


## IDE support 

Dotty comes with it's own language server protocol (LSP) implementation, see http://dotty.epfl.ch/docs/usage/ide-support.html
* Currently, the only IDE we officially support is Visual Studio Code, using the above LSP
* IntelliJ supports for dotty is very limited at the time of writing, especially if new dotty syntax is used extensively 
* LSP can be used with other editors too, but it requires manual configuration. For vim, a guide can be found here: https://www.dev-log.me/Coc_Vim_with_Dotty/
* Metals v0.9.5 has some support for dotty https://scalameta.org/metals/blog/ 







