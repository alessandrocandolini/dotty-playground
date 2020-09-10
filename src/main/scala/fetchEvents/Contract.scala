package fetchEvents
import sttp.tapir._
import models._
import models.Pagination._


val fetchEventsEndpoint : Endpoint[(Limit, AuthToken), Erratum, List[Event],Nothing] = ??? 



