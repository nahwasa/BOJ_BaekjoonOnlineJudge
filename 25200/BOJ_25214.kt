import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var min = Int.MAX_VALUE
    val st = StringTokenizer(readLine())
    val sb = StringBuilder()
    var ans = 0
    repeat(n) {
        val cur = st.nextToken().toInt()
        if (min > cur) min = cur
        else ans = Math.max(ans, cur-min)
        sb.append(ans).append(' ')
    }
    println(sb)
}
