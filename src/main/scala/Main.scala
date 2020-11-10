import utils._

import sttp.tapir._

@main def main =
    println("Hello dotty!")
    println(msg)



val statusEndpoint = endpoint.get.in(
  EndpointInput.FixedPath("status", Codec.idPlain(), EndpointIO.Info.empty)
  )

def msg = "I was compiled by dotty :)"

def comp[T](using Eq[T]): T => T => Boolean = a => b => a != b 


