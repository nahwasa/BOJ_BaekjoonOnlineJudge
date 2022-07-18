import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    var tc = 0
    val sb = StringBuilder()
    repeat(t) {
        var st = StringTokenizer(readLine())
        val arr = IntArray(3)
        for (i in 0..2) arr[i] = st.nextToken().toInt()
        arr.sort()
        val answer = arr[2]*arr[2]==arr[0]*arr[0]+arr[1]*arr[1]
        sb.append(String.format("Case #%d: %s\n", ++tc, if (answer) "YES" else "NO"))
    }
    println(sb)
}
