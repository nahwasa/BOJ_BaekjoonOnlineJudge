import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    ArrayList<Integer>[] bit;
    int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    private void update(int idx, int val) {
        while (idx <= n) {
            bit[idx].add(val);
            idx += idx&-idx;
        }
    }

    private int getCntOfOver(ArrayList<Integer> list, int k) {
        int res = Collections.binarySearch(list, k+1);
        if (res < 0) {
            res += 1;
            res = -res;
        }
        return list.size() - res;
    }

    private int prefixSumOfCnt(int idx, int k) {
        int cnt = 0;
        while (idx > 0) {
            cnt += getCntOfOver(bit[idx], k);
            idx -= idx&-idx;
        }
        return cnt;
    }

    private int query(int i, int j, int k) {
        return prefixSumOfCnt(j, k) - prefixSumOfCnt(i-1, k);
    }

    private int getAnswer(int a, int b, int c) {
        c = b-a+1-c;
        int start = min;
        int end = max;
        while (start<=end) {
            int mid = (start+end)/2;
            if (query(a,b,mid) > c)
                start = mid+1;
            else
                end = mid-1;
        }
        return start;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        bit = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) bit[i] = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (max<cur) max = cur;
            if (min>cur) min = cur;
            update(i, cur);
        }
        for (int i = 1; i <= n; i++) Collections.sort(bit[i]);

        StringBuilder sb = new StringBuilder();
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sb.append(getAnswer(a,b,c)).append('\n');
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
