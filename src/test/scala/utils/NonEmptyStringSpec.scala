package utils
import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import org.scalacheck.Gen

object NonEmptyStringSpec extends Properties("NonEmptyString.safe must"):

  val nonEmptyRawStringGen : Gen[String] = Gen.alphaNumStr.filter(_.nonEmpty)
  
  val emptyRawStringGen : Gen[String] = 
    Gen.listOf(Gen.oneOf("", " ")).map(_.mkString)

  property("never return None for alphanum strings") = forAll(nonEmptyRawStringGen) {
      s => NonEmptyString.safe(s).isDefined
  }

  property("always return None for strings containing only blank characters") = forAll(emptyRawStringGen) {
      s => NonEmptyString.safe(s).isEmpty
  }