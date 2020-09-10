import utils._



enum ValidationResult derives Eql: 
    case EmptyTitle
    case OverlappingEvents
    case EmptyDate
    case Success(c : Calendar)

case class Calendar(title : NonEmptyString) derives Eql

def validate[V](using ord : Ord[V]) : String => V => V => ValidationResult = t => s => e => 
    NonEmptyString.safe(t) match 
        case None =>   ValidationResult.EmptyTitle
        case Some(n) => 
            if ord.compare(s)(e) != OrdResult.LT
               ValidationResult.EmptyDate
            else  
               ValidationResult.Success(Calendar(n))


           


