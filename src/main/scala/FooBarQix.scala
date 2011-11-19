
/**
 * @author David Galichet.
 */

object FooBarQix {
  
  def scheme(mod:Int, replacement:String) = { x:Int =>
    (if (x % mod == 0) replacement else "")  +
      x.toString.fold("") {
        case (acc, elem) if (elem == mod.toString.head) => replacement + acc
        case (acc, _) => acc
      }
  }

  def foo = scheme(3, "foo")
  def bar = scheme(5, "bar")
  def qix = scheme(7, "qix")

  def fooBarQix = { x:Int => { y:String => (if (y.isEmpty) x.toString else y)}.apply(foo(x) + bar(x) + qix(x)) }

  def main(args: Array[String]) {
    println((1 to 100).map(fooBarQix).mkString("\n"))
  }
}
