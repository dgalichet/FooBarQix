
/**
 * @author David Galichet.
 */

object FooBarQix {

  // Returns a function that transform an Int to a String
  def scheme(mod:Int, replacement:String): Int => String = { x:Int =>
    (if (x % mod == 0) replacement else "")  +
      x.toString.fold("") {
        case (acc, elem) if (elem == mod.toString.head) => replacement + acc
        case (acc, _) => acc
      }
  }

  // Create the three transformations patterns
  val foo = scheme(3, "foo")
  val bar = scheme(5, "bar")
  val qix = scheme(7, "qix")

  // apply transformations to x and returns the result or x if empty
  val fooBarQix: Int => String = { x:Int => { y:String => (if (y.isEmpty) x.toString else y)}.apply(foo(x) + bar(x) + qix(x)) }

  def main(args: Array[String]) {
    println((1 to 100).map(fooBarQix).mkString("\n"))
  }
}
