package utils 

opaque type NonEmptyString = String
  
object NonEmptyString:

    // see https://github.com/lampepfl/dotty/pull/9884
    // https://dotty.epfl.ch/docs/reference/other-new-features/explicit-nulls.html#match-case
    def safe : String => Option[NonEmptyString] = _.trim match  // Java's trim returns String|Null
      case s : String if s != "" => Some(s)
      case _  => None

     

