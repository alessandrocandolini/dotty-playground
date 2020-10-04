package utils 

opaque type NonEmptyString = String
  
object NonEmptyString:

    // see https://github.com/lampepfl/dotty/pull/9884
    def safe : String => Option[NonEmptyString] = _.trim match  // Java's trim returns String|Null
      case null  => None
      case "" => None
      case s : String => Some(s)

     

