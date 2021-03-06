import utils._

import sttp.tapir._
import sttp.tapir.json.circe._
import io.circe.Encoder
import io.circe.Json 

@main def program =
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

def msg = "I was compiled by dotty :)"

def comp[T](using CanEqual[T,T]): T => T => Boolean = a => b => a != b 

def f(x : Int) : Int = {
  0
}
