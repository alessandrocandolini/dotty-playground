trait Ord[T]:
    def compare: T => T => OrdResult

enum OrdResult derives Eql:
    case LT
    case GT
    case EQ


object EmptyTitle
object OverlappingEvents
object EmptyDate

case class Calendar(title : String) derives Eql

def validate[T](title : String, startDate : T, endDate : T)(using ord : Ord[T]) = 
    if title.isEmpty
        EmptyTitle
    else if ord.compare(startDate)(endDate) != OrdResult.LT
        EmptyDate
    else  
        Calendar(title)     


given intOrd as Ord[Int]:
    def compare: Int => Int => OrdResult = a => b => 
        import OrdResult._
        if a > b 
           GT
        else if a == b 
           EQ
        else 
           LT   


