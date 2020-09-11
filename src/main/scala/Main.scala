import utils._
@main def main =
    println("Hello dotty!")
    println(msg)

def msg = "I was compiled by dotty :)"

def comp[T](using Eq[T]): T => T => Boolean = a => b => a != b 


