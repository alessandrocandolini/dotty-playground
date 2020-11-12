import utils._

import sttp.tapir._

@main def main =
    println("Hello dotty!")
    println(msg)



val statusEndpoint = endpoint.get.in(
  EndpointInput.FixedPath("status", Codec.idPlain(), EndpointIO.Info.empty)
  )

def msg = "I was compiled by dotty :)"

def comp[T](using Eq[T]): T => T => Boolean = a => b => a != b 

/*
// A | B = B | A (commutative) 
// A | A ~ A  (ismorphic to A) 

trait HasCategoryId 
  val categoryId : CategoryId
trait HasBrandId
  val brandId : BrandId


// 1. head on nonempty list 
// def head[A] : List[A] => Option[A]A
// 2. refined tyoes 
// 3. option or either 


// case class 
// tuple (CategoryId, ProductId) kkkk

def validateCategory : CategoryId => Either[categoryError, CategoryId] 
def validateBrand : BrandId => Either[BrandError, BrandId] 

def validate : CategoryId => BrandId => Either[CategoryErorr | BrandError, (CategoryId, BrandId) ] 
def validateProduct : HasCategoryId & HasBrandId  => Either[CategoryErorr | BrandError, Product] 



val ab : A&B 

//def a : Either[EA, A] = ???  
object Exp:
  trait E
  trait E2 
  trait A
  trait B 
  val ae : E|A  = ???
  val a : A = ae E|A = A|E , A|A ~ A
  val aet : Either[E,A] = ???
  def f : A => Either[E, B] 
  def g : A => Either[E2, B] 
  def flatMap[E,E2, A](f : A => Either[E2, B]) : Either[E, A] => Either[E2|E, B] = 
     case Right(a) => f(a) // Either[E2, B] 
     case Left(e) => e is of type E 
  val bet : Either[E|E2|E3,B] = for {
      a <- aet
      b <- f(a) // Either[ Either[E, E2], B] 
      c <- g(a) // Either[ Either[ Either[E, E2], E3] , C] 
  } yield { b } 

*/
