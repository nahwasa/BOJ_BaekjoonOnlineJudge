import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class A implements Comparable<A> {
    int idx, k;
    public A(int idx, int k) {
        this.idx = idx;
        this.k = k;
    }

    @Override
    public int compareTo(A o) {
        return o.k - this.k;
    }
}

class Query implements Comparable<Query> {
    int idx, a, b, k;
    public Query(int idx, int a, int b, int k) {
        this.idx = idx;
        this.a = a;
        this.b = b;
        this.k = k;
    }

    @Override
    public int compareTo(Query o) {
        return o.k - this.k;
    }
}

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        A[] arr = new A[n+1];
        arr[0] = new A(-1, 0);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = new A(i, Integer.parseInt(st.nextToken()));
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        Query[] queries = new Query[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i] = new Query(i,
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(queries);

        boolean[] chk = new boolean[n+1];
        int sqrtN = (int)Math.sqrt(n);
        int[] bucket = new int[1000];
        int[] answer = new int[m];
        for (int i = 0, j = 0; i < m; i++) {
            Query q = queries[i];

            // update
            while(j <= n && arr[j].k > q.k) {
                chk[arr[j].idx] = true;
                bucket[arr[j].idx/sqrtN]++;
                j++;
            }

            // get answer
            int sum = 0;
            int a = q.a;
            int b = q.b;
            while (a%sqrtN!=0 && a<=b) if (chk[a++]) sum++;
            while ((b+1)%sqrtN!=0 && a<=b) if (chk[b--]) sum++;
            for (int z = a/sqrtN; z < (b+1)/sqrtN; z++) sum += bucket[z];
            answer[q.idx] = sum;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) sb.append(answer[i]).append('\n');
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
