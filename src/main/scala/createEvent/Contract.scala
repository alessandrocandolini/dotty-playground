package createEvent
import sttp.tapir._
import models._

val postEventEndpoint : Endpoint[(Event,AuthToken), Erratum, Unit, Nothing] = ???
