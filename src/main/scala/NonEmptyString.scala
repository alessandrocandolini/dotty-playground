opaque type NonEmptyString = String
  
object NonEmptyString:
   
    def safe : String => Option[NonEmptyString] = 
      case "" => None
      case s => Some(NonEmptyString(s))

