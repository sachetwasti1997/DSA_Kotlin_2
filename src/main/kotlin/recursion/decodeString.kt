import java.util.*
import kotlin.collections.HashSet

fun decodeString(s: String): String {
  val stk = Stack<String>()
  for (i in s) {
    if (i != ']') {
      stk.add(i.toString())
    }else {
      val sbstr = StringBuilder()
      while (stk.peek() != "[") {
        sbstr.insert(0, stk.pop())
      }
      stk.pop()
      val nmb = StringBuilder()
      while (!stk.isEmpty() && (stk.peek() in ("0".."9"))) {
        nmb.insert(0, stk.pop())
      }
      nmb.reverse()
      val num = nmb.toString().toInt()
      val res = StringBuilder()
      for (it in 1..num) {
        res.append(sbstr)
      }
      stk.add(res.toString())
    }
  }
  return stk.joinToString(separator = "")
}

fun main() {
  val nm = "8"
  val rng = "0" .. "9"
  println("0" < "8")
  println("8" > "9")
  println(rng.contains(nm))
  println(nm in "0" .. "9")
  decodeString("2[abc]3[cd]ef")
}