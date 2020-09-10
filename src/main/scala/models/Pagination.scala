package models
import utils._

opaque type Limit = PositiveInt 
object Limit:
   def safe : Int => Option[Limit] = PositiveInt.safe
    
opaque type Cursor = NonEmptyString 
object Cursor:
   def safe : String => Option[Cursor] = NonEmptyString.safe