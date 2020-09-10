package utils

trait Ord[T]:
    def compare: T => T => OrdResult
    
enum OrdResult derives Eql:
    case LT
    case GT
    case EQ

given Ord[Int]:
    def compare: Int => Int => OrdResult = a => b => 
        import OrdResult.{EQ,GT,LT}
        if a > b 
           GT
        else if a == b 
           EQ
        else 
           LT     