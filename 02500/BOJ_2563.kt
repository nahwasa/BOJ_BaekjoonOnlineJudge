import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(100){IntArray(100){0}}
    var ans = 0
    repeat(n) {
        val st = StringTokenizer(readLine())
        val r = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        for (i in 0 until 10) {
            for (j in 0 until 10) {
                if (++arr[r+i][c+j] == 1)
                    ans++
            }
        }
    }
    print(ans)
}
