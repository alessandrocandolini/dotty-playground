package utils 

opaque type NonEmptyString = String
  
object NonEmptyString:
   
    def safe : String => Option[NonEmptyString] = _.trim match 
      case "" => None
      case s => Some(s)

