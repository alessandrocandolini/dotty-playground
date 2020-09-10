package models

import java.time.ZonedDateTime
import utils._

case class Event(
    id : EventId,
    creator : UserId,
    description : NonEmptyString,
    startDate : EventTime,
    endDate : EventTime
) derives Eql
  
