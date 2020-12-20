import utils._
import Maybe._
import ValidationResult._
import utils.Ord

enum ValidationResult derives CanEqual: 
    case EmptyTitle
    case OverlappingEvents
    case EmptyDate
    case Success(c : Calendar)

case class Calendar(title : NonEmptyString) derives CanEqual

enum Maybe[+A] derives CanEqual:
  case Empty
  case Just(a : A)


trait Box[+T]
case class BoxSome[+T](x: T) extends Box[T]
case object BoxNone extends Box[Nothing]  

def isDefined3[A] : Box[A] => Boolean = 
  case BoxSome(_) => true 
  case BoxNone => false 

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
