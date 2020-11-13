import utils._
import Maybe._
import ValidationResult._

enum ValidationResult derives Eql: 
    case EmptyTitle
    case OverlappingEvents
    case EmptyDate
    case Success(c : Calendar)

case class Calendar(title : NonEmptyString) derives Eql

enum Maybe[+A] derives Eql:
  case Empty
  case Just(a : A)

def isDefined[A] : Maybe[A] => Boolean = 
  case Just(_) => true 
  case Empty => false 

def isDefined2[A] : Option[A] => Boolean = 
  case Some(_) => true 
  case None => false 


def validate[A](using ord: Ord[A]) : String => A => A => ValidationResult = s => a => n => 
    NonEmptyString.safe(s) match
      case Some(s) => if ord.compare(a)(n) != OrdResult.GT then OverlappingEvents else Success(Calendar(s))
      case _ => EmptyTitle
