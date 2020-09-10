package utils

opaque type PositiveInt = Int
  
object PositiveInt:
   
    def safe : Int => Option[PositiveInt] = 
      case i if i > 0 => Some(i)
      case _ => None

opaque type PositiveLong = Long
  
object PositiveLong:
   
    def safe : Long => Option[PositiveLong] = 
      case i if i > 0 => Some(i)
      case _ => None      