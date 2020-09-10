package createEvent
import sttp.tapir._
import models._
import models.Pagination._

val postEventEndpoint : Endpoint[(Event,AuthToken), Erratum, Unit, Nothing] = ???
