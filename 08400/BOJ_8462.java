import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Query implements Comparable<Query> {
    int a, b, idx, compFactor;
    static int sqrtN;
    public static void setSqrtN(int n) { sqrtN = (int)Math.sqrt(n); }
    public Query(int a, int b, int idx) {
        this.a = a;
        this.b = b;
        this.idx = idx;
        this.compFactor = this.a/sqrtN;
    }
    @Override
    public int compareTo(Query o) {
        if (this.compFactor == o.compFactor)
            return this.b-o.b;
        return this.compFactor-o.compFactor;
    }
}
public class Main {
    int[] cnt = new int[1000001];
    long answer = 0;
    private void push(int num) {
        answer-=1l*num*cnt[num]*cnt[num];
        answer+=1l*num*++cnt[num]*cnt[num];
    }
    private void pop(int num) {
        answer-=1l*num*cnt[num]*cnt[num];
        answer+=1l*num*--cnt[num]*cnt[num];
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 2<<17);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        Query.setSqrtN(n);
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Query[] queries = new Query[t];
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i] = new Query(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
        }
        Arrays.sort(queries);
        for (int i = queries[0].a; i <= queries[0].b; i++) push(arr[i]);
        long[] ansArr = new long[t];
        ansArr[queries[0].idx] = answer;
        int a = queries[0].a;
        int b = queries[0].b;
        for (int i = 1; i < t; i++) {
            Query q = queries[i];
            for (int x = q.a; x < a; x++) push(arr[x]);
            for (int x = b+1; x <= q.b; x++) push(arr[x]);
            for (int x = a; x < q.a; x++) pop(arr[x]);
            for (int x = q.b+1; x <= b; x++) pop(arr[x]);
            a = q.a;
            b = q.b;
            ansArr[q.idx] = answer;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) sb.append(ansArr[i]).append('\n');
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
