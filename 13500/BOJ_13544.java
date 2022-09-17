import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    ArrayList<Integer>[] bit;
    int n;

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

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bit = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) bit[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            update(i, Integer.parseInt(st.nextToken()));
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(bit[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int lastAnswer = 0;
        StringBuilder sb = new StringBuilder();
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int i = a^lastAnswer;
            int j = b^lastAnswer;
            int k = c^lastAnswer;
            lastAnswer = (int)query(i, j, k);
            sb.append(lastAnswer).append('\n');
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
