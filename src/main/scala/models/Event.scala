package models

import java.time.ZonedDateTime
import utils._

case class Event(
    id : EventId,
    creator : UserId,
    description : EventDescription,
    startDate : EventTime,
    endDate : EventTime
) derives CanEqual


opaque type EventDescription = NonEmptyString 
object EventDescription:
   def safe : String => Option[EventDescription] = NonEmptyString.safe
  
