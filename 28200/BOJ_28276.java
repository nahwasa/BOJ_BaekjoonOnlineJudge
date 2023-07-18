import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    int r, c, w;
    boolean[][] arr;
    int[] parents;
    List<UfOrder> orders = new ArrayList<>();

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        arr = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = row.charAt(j) == '1';
            }
        }

        parents = new int[r*c];

        int start = 0;
        int end = 1000000;
        while (start<=end) {
            int mid = (start+end)/2;

            Arrays.fill(parents, -1);
            orders = new ArrayList<>();

            if (!isPossible(mid))
                start = mid+1;
            else
                end = mid-1;
        }

        System.out.println(start);
    }

    private int find(int a) {
        if (parents[a] < 0) return a;

        orders.add(new UfOrder(a, parents[a]));
        return parents[a] = find(parents[a]);
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;

        int hi = parents[a]<=parents[b]?a:b;
        int lo = parents[a]<=parents[b]?b:a;
        orders.add(new UfOrder(hi, parents[hi]));
        parents[hi]+=parents[lo];
        orders.add(new UfOrder(lo, parents[lo]));
        parents[lo] = hi;
    }

    private boolean isPossible(final int limit) {
        int j = 0;
        int wIdx = 0;

        for (int wCnt = 0; wCnt <= w && j < c; wCnt++) {
            boolean chk = true;

            while (j<c) {
                for (int i = 0; i < r && j < c; i++) {
                    if (!arr[i][j]) continue;

                    int ufIdx = i*c+j;

                    if (i-1>=0 && arr[i-1][j]) {
                        int otherIdx = (i-1)*c+j;
                        union(ufIdx, otherIdx);
                    }

                    if (j-1>=0 && j-1>=wIdx && arr[i][j-1]) {
                        int otherIdx = i*c+(j-1);
                        union(ufIdx, otherIdx);
                    }

                    int cur = -parents[find(ufIdx)];
                    if (cur > limit) {
                        if (wIdx == j) return false;
                        chk = false;
                        wIdx = j;

                        for (int k = orders.size()-1; k >= 0; k--) {
                            UfOrder curOrder = orders.get(k);
                            parents[curOrder.idx] = curOrder.bf;
                        }
                        orders = new ArrayList<>();

                        break;
                    }
                }

                if (chk) {
                    j++;
//                    orders = new ArrayList<>();
                }
                else break;
            }
        }

        return j == c;
    }
}

class UfOrder {
    int idx;
    int bf;

    public UfOrder(final int idx, final int bf) {
        this.idx = idx;
        this.bf = bf;
    }
}
