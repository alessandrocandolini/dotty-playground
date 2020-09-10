package models
import utils._

opaque type UserId = PositiveLong 
object UserId:
  def safe : Long => Option[UserId] = PositiveLong.safe

opaque type EventId = PositiveLong 
object EventId:
  def safe : Long => Option[EventId] = PositiveLong.safe