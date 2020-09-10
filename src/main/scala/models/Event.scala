package models
import java.time.ZonedDateTime
import utils._

object Pagination {

  opaque type Limit = Int 
  object Limit:
    def safe : Limit => Option[Limit] = 
       case i if i >= 0 => Some(i)
       case _ => None

}

opaque type UserId = Long 
object UserId:
  def safe : Long => Option[UserId] = 
    case i if i >= 0 => Some(i)
    case _ => None

opaque type EventId = Long 
object EventId:
  def safe : Long => Option[EventId] = 
    case i if i >= 0 => Some(i)
    case _ => None    

opaque type AuthToken = String 
object AuthToken:
  def apply : String => AuthToken = s => s

opaque type EventTime = ZonedDateTime 
object EventTime:
  
  def apply : ZonedDateTime => EventTime = d => d
  
  given Ord[EventTime]:

    import utils.{given Ord[Int]}

    def compare: EventTime => EventTime => OrdResult = a => b =>
        
        val aNano = a.getNano()
        val bNano = b.getNano()

        summon[Ord[Int]].compare(aNano)(bNano)
    

enum Erratum derives Eql:
  case Unauthorised 

case class Event(
    id : EventId,
    creator : UserId,
    description : NonEmptyString,
    startDate : EventTime,
    endDate : EventTime
)
  
