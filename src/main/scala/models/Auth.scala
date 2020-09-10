package models
import utils._

opaque type AuthToken = NonEmptyString 
object AuthToken:
  def safe : String => Option[AuthToken] = NonEmptyString.safe

// TODO authorisation 
