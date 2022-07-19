import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.min

const val INF = 257
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    var m = st.nextToken().toInt()
    val arr = Array(n){IntArray(n){INF}}
    repeat(m) {
        st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()-1
        val b = st.nextToken().toInt()-1
        arr[a][b] = 1
    }
    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == j || arr[i][k] == INF || arr[k][j] == INF) continue
                arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j])
            }
        }
    }
    val sb = StringBuilder()
    for (i in 0 until n) {
        var outCnt = 0
        var inCnt = 0
        for (j in 0 until n) {
            if (i == j) continue
            if (arr[i][j] != INF && arr[j][i] != INF) return println(-1)
            if (arr[i][j] != INF) outCnt++
            if (arr[j][i] != INF) inCnt++
        }
        sb.append(inCnt+1).append(' ').append(n-outCnt).append('\n')
    }
    print(sb)
}
