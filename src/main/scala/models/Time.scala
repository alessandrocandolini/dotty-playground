package models

import java.time.ZonedDateTime
import utils._

opaque type EventTime = ZonedDateTime
object EventTime:
  
  def apply : ZonedDateTime => EventTime = d => d
  
  given Ord[EventTime]:

    import utils.{given Ord[Int]}

    def compare: EventTime => EventTime => OrdResult = a => b =>
        
        val aNano = a.getNano()
        val bNano = b.getNano()

        summon[Ord[Int]].compare(aNano)(bNano)
    

