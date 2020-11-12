object TitleValidationError
object DueDateValidationError

import MyEither.Left
import MyEither.Right 

val validateTitle : String => MyEither[TitleValidationError.type, String]  =  
    case "" => Left(TitleValidationError)
    case s => Right(s)

val validateDate : String => MyEither[DueDateValidationError.type, String] = 
  case "" => Left(DueDateValidationError)
  case s => Right(s)  

val validateBoth : String => String => MyEither[TitleValidationError.type | DueDateValidationError.type, (String, String) ] = 
  t => d => for {
    t1 <- validateTitle(t) 
    d1 <- validateDate(d) 
  } yield (t1,d1)

def validateBothTypeInference(title : String, date : String) = 
  for {
    t <- validateTitle(title) 
    s <- validateDate(date) 
  } yield {
    (t,s)
  }

enum MyEither[+A,+B] derives Eql:
   case Left(a : A) 
   case Right(b : B)



extension[A,B,C] (ea : MyEither[A,B]) 
  def map(f : B => C) : MyEither[A,C] = ea match
     case Left(l) => Left(l)
     case Right(r) => Right(f(r))

extension[A,B,EA, EB] (ea : MyEither[EA,A]) 
   def flatMap(f : A => MyEither[EB, B]) : MyEither[EA|EB,B] = ea match
     case MyEither.Left(l) => MyEither.Left(l)
     case MyEither.Right(r) => f(r)
