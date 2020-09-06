import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

class CalendarSpec extends Properties("validate") {

  property("return empty title") = forAll { (a: Int, b: Int) =>
    validate("")(a)(b) == ValidationResult.EmptyTitle
  }
 
  
}
