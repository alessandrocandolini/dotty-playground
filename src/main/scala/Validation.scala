object TitleValidationError
object DueDateValidationError

val validateTitle : String => TitleValidationError.type | String  =  // Either[Erratum, A]
    case "" => TitleValidationError
    case s => s 

val validateDate : String => DueDateValidationError.type | String = 
  case "" => DueDateValidationError
  case s => s 

val validateBoth : String => TitleValidationError.type | DueDateValidationError.type | String =
  s => validateTitle(s) match
    case TitleValidationError => TitleValidationError 
    case p : String => validateDate(p)

enum MyEither[+A,+B] derives Eql:
   case Left(a : A) extends MyEither[A, Nothing]
   case Right(b : B) extends MyEither[Nothing, B]



extension[A,B,C] (ea : MyEither[A,B]) 
  def map(f : B => C) : MyEither[A,C] = ea match
     case MyEither.Left(l) => MyEither.Left(l)
     case MyEither.Right(r) => MyEither.Right(f(r))

extension[A,B,EA, EB] (ea : MyEither[EA,A]) 
   def flatMap(f : A => MyEither[EB, B]) : MyEither[EA|EB,B] = ea match
     case MyEither.Left(l) => MyEither.Left(l)
     case MyEither.Right(r) => f(r)
     



     /*
      *
      *
      *
   
trait Something 
  def doSomething

class A extends Something
  def doSomething()


class B(a : A) extends Something 
  override def doSomething() = a.doSomething()



def simpleFlatMap[A,B,C](f : B => MyEither[A,C]) : MyEither[A,B] => MyEither[A,C] = 
     case Left(l) => Left(l)
     case Right(r) => f(r) 
  
def flatMap[A,A1 >: A, B,C](f : B => MyEither[A1,C]) : MyEither[A,B] => MyEither[A1,C] = 
     case Left(l) => l 
     case Right(r) => f(r) 

extension[A,B,C] (e : MyEither[A,B]):
   def map(f : B => C) : MyEither[A,C] = e match {
       case Right(r) => Right[A,C](f(r))
       case Left(l) => Left[A,C](l)
   }


extension[A,B,C] (e : MyEither[A,B]):
   def flatMapSimple(f : B => MyEither[A,C]) : MyEither[A,C] = e match {
       case Right(r) => f(r) 
       case Left(l) => Left[A,C](l)
   }
*/
