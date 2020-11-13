import utils._

import sttp.tapir._
import sttp.tapir.json.circe._
import io.circe.Encoder
import io.circe.Json 

@main def main =
    println("Hello dotty!")
    println(msg)

case class StatusResponse(status : String) 
object StatusResponse:
  val default = StatusResponse("OK") 
  given Encoder[StatusResponse] = new Encoder[StatusResponse] {
    final def apply(a: StatusResponse): Json = Json.obj(
      ("status", Json.fromString(a.status))
    )
  }
    
object Endpoints: 

  import scala.language.implicitConversions 

  val statusEndpoint = endpoint.get.in("status")



object TapirConversion:

  given [A] as Conversion[String, EndpointInput.FixedPath[Unit]]:
    def apply(s: String): EndpointInput.FixedPath[Unit] = 
      EndpointInput.FixedPath(s, Codec.idPlain(), EndpointIO.Info.empty)

def msg = "I was compiled by dotty :)"

def comp[T](using Eq[T]): T => T => Boolean = a => b => a != b 

