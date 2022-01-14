import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] arr, seg;

    private static void init(int n, int s, int e) {
        if (s==e) {
            seg[n]=arr[s];
            return;
        }
        int m = (s+e)/2;
        init(n*2,s,m);
        init(n*2+1,m+1,e);
        seg[n]=seg[n*2]+seg[n*2+1];
    }

    private static void update(int n, int s, int e, int t, long diff) {
        if (t<s || t>e)
            return;
        seg[n]+=diff;
        if (s==e)
            return;
        int m = (s+e)/2;
        update(n*2,s,m,t,diff);
        update(n*2+1,m+1,e,t,diff);
    }

    private static long query(int n, int s, int e, int l, int r) {
        if (s>r || l>e)
            return 0;
        if (l<=s && e<=r)
            return seg[n];
        int m = (s+e)/2;
        long q1 = query(n*2, s, m, l, r);
        long q2 = query(n*2+1, m+1, e, l, r);
        return q1 + q2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // input
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        arr = new long[N+1];
        seg = new long[1<<(h+1)];
        for (int i = 1; i <= N; i++)
            arr[i] = Long.parseLong(br.readLine());
        // seg init
        init(1, 1, N);
        // proc
        while (M-->0) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "1" :
                    int t = Integer.parseInt(st.nextToken());
                    long v = Long.parseLong(st.nextToken());
                    long diff = v-arr[t];
                    arr[t] = v;
                    update(1, 1, N, t, diff);
                    break;
                case "2" :
                    int l = Integer.parseInt(st.nextToken());
                    int r = Integer.parseInt(st.nextToken());
                    bw.write(query(1, 1, N, l, r) + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
