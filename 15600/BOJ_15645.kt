import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

const val VALUE_SUM_LIMIT = 9*100000+1

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var n = readLine().toInt()
    var max = Array(3){0}
    var min = Array(3){0}
    while(n-->0) {
        val st = StringTokenizer(readLine())
        val maxTmp = Array(3){0}
        val minTmp = Array(3){VALUE_SUM_LIMIT}
        var i = 0
        while (st.hasMoreTokens()) {
            val cur = st.nextToken().toInt()
            for (j in i-1..i+1) {
                if (j < 0 || j >= 3) continue
                maxTmp[i] = Math.max(maxTmp[i], max[j])
                minTmp[i] = Math.min(minTmp[i], min[j])
            }
            maxTmp[i]+=cur
            minTmp[i]+=cur
            i++
        }
        max = maxTmp
        min = minTmp
    }
    println("${max.toList().maxOrNull()} ${min.toList().minOrNull()}")
}
