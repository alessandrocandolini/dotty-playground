@main def main =
    println("Hello dotty!")
    println(msg)

def msg = "I was compiled by dotty :)"

def comp[T,V](using Eql[T,V]): T => V => Boolean = a => b => a != b 


