enum ValidationError derives Eql:
  case NoTitle 
  case PastDueDate

object TitleValidationError
object DueDateValidationError

val validateTitle : String => TitleValidationError.type | String  = 
    case "" => TitleValidationError
    case s => s 

val validateDate : String => DueDateValidationError.type | String = 
  case "" => DueDateValidationError
  case s => s 

val validateBoth : String => TitleValidationError.type | DueDateValidationError.type | String =
  s => validateTitle(s) match
    case TitleValidationError => TitleValidationError 
    case p : String => validateDate(p)
