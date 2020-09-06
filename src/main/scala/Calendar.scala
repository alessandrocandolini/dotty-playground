trait Ord[T]:
    def compare: T => T => OrdResult
    
enum OrdResult derives Eql:
    case LT
    case GT
    case EQ

trait Emptyness[T]:
    def isEmpty: T => Boolean      

enum ValidationResult derives Eql: 
    case EmptyTitle
    case OverlappingEvents
    case EmptyDate
    case Success

case class Calendar(title : String) derives Eql

def validate[T,V](using empt : Emptyness[T], ord : Ord[V]) : T => V => V => ValidationResult = t => s => e => 
    if empt.isEmpty(t)
        ValidationResult.EmptyTitle
    else if ord.compare(s)(e) != OrdResult.LT
        ValidationResult.EmptyDate
    else  
        ValidationResult.Success


given intOrd as Ord[Int]:
    def compare: Int => Int => OrdResult = a => b => 
        import OrdResult._
        if a > b 
           GT
        else if a == b 
           EQ
        else 
           LT  
           
           
given stringEmptyness as Emptyness[String]:
    def isEmpty: String => Boolean = _.isEmpty


