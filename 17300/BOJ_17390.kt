import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private fun getRangedSum(arr: IntArray, l: Int, r: Int): Int {
    return arr[r] - arr[l-1];
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val q = st.nextToken().toInt()
    var arr = IntArray(n+1)
    st = StringTokenizer(readLine())
    for (i in 1 .. n) {
        arr[i] = st.nextToken().toInt()
    }
    arr.sort()

    for (i in 1 .. n) {
        arr[i] += arr[i-1];
    }

    val answer = StringBuilder();
    repeat(q) {
        st = StringTokenizer(readLine())
        val l = st.nextToken().toInt()
        val r = st.nextToken().toInt()
        answer.append(getRangedSum(arr, l, r)).append('\n')
    }
    print(answer)
}
