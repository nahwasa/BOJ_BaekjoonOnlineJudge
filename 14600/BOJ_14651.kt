import java.io.BufferedReader
import java.io.InputStreamReader

const val MOD = 1_000_000_009
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var dp = arrayOf(0, 1, 1)
    repeat(n-1) {
        var tmp = Array(3) {0}
        for (i in 0..2) {
            for (j in 0 .. 2) {
                val idx = (i+j)%3
                tmp[idx]+=dp[j]
                tmp[idx]%=MOD
            }
        }
        dp = tmp
    }
    println(dp[0])
}
