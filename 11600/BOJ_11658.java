import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int N;
    int[][] arr, bit;

    private int getPrefixSum(int r, int c) {
        int sum = 0;
        while (r > 0) {
            int cc = c;
            while (cc > 0) {
                sum += bit[r][cc];
                cc -= cc&-cc;
            }
            r -= r&-r;
        }
        return sum;
    }

    private void update(int r, int c, int diff) {
        while (r <= N) {
            int cc = c;
            while (cc <= N) {
                bit[r][cc] += diff;
                cc += cc&-cc;
            }
            r += r&-r;
        }
    }

    private void initBit() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                update(i, j, arr[i][j]);
            }
        }
    }

    private int query(int x1, int y1, int x2, int y2) {
        return getPrefixSum(x2, y2) - getPrefixSum(x2, y1-1) - getPrefixSum(x1-1,y2) + getPrefixSum(x1-1, y1-1);
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        bit = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        initBit();

        StringBuilder sb = new StringBuilder();
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(st.nextToken())) {
                case 0:
                    int r = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    int val = Integer.parseInt(st.nextToken());
                    int diff = val - arr[r][c];
                    arr[r][c] = val;
                    update(r, c, diff);
                    break;
                case 1:
                    int x1 = Integer.parseInt(st.nextToken());
                    int y1 = Integer.parseInt(st.nextToken());
                    int x2 = Integer.parseInt(st.nextToken());
                    int y2 = Integer.parseInt(st.nextToken());
                    sb.append(query(x1,y1,x2,y2)).append('\n');
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
