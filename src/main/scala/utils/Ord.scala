package utils

trait Ord[T]:
    def compare: T => T => OrdResult
    
enum OrdResult derives CanEqual:
    case LT, GT, EQ

given Ord[Int]:
    def compare: Int => Int => OrdResult = a => b => 
        import OrdResult.{EQ,GT,LT}
        if a > b then
          GT
        else if a == b then
          EQ
        else
          LT 
