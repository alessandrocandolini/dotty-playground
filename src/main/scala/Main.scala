import utils._

import sttp.tapir._

@main def main =
    println("Hello dotty!")
    println(msg)

object Endpoints: 

  import scala.language.implicitConversions 

  val statusEndpoint = endpoint.get.in("status")


object TapirConversion:

  given [A] as Conversion[String, EndpointInput.FixedPath[Unit]]:
    def apply(s: String): EndpointInput.FixedPath[Unit] = 
      EndpointInput.FixedPath(s, Codec.idPlain(), EndpointIO.Info.empty)

def msg = "I was compiled by dotty :)"

def comp[T](using Eq[T]): T => T => Boolean = a => b => a != b 

