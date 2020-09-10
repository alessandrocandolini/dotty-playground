package utils
import OrdResult.{EQ,GT,LT}
import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import org.scalacheck.Gen
import org.scalacheck.Prop.propBoolean

object OrdIntSpec extends Properties("Ord[Int] must"):

  val comp : Int => Int => OrdResult =  summon[Ord[Int]].compare

  property("always return EQ when comparing a int with itself") = forAll { (x : Int) => 
      comp(x)(x) == EQ
  }

  property("always return either GT or LT when the two args are different") = forAll { (x : Int, y : Int) => 
      (comp(x)(y) != EQ) ==> {
          x != y
      }
  }

  property("always return GT if swapping the order of the arguments returns LT") = forAll { (x : Int, y : Int) => 
      (comp(x)(y) == LT) ==> {
        comp(y)(x) == GT
      }
  }

  property("always return LT if swapping the order of the arguments returns GT") = forAll { (x : Int, y : Int) => 
      (comp(x)(y) == GT) ==> {
        comp(y)(x) == LT
      }
  }

  