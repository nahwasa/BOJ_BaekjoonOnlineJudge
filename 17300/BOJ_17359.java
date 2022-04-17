import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    int n;
    int[][] arr;
    boolean[] v;
    int minCnt = 1001;

    private void recursion(int idx, int last, int cnt) {
        if (idx == n) {
            if (minCnt > cnt)
                minCnt = cnt;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (v[i]) continue;
            v[i] = true;
            recursion(idx+1, arr[i][1], cnt+(last != arr[i][0] ? 1 : 0));
            v[i] = false;
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        v = new boolean[n];
        arr = new int[n][2];
        int confirmedCnt = 0;
        for (int i = 0; i < n; i++) {
            String cur = br.readLine();
            for (int j = 1; j < cur.length(); j++) {
                if (cur.charAt(j-1) != cur.charAt(j))
                    confirmedCnt++;
            }
            arr[i][0] = cur.charAt(0)-'0';
            arr[i][1] = cur.charAt(cur.length()-1)-'0';
        }
        recursion(0, -1,-1);
        System.out.println(confirmedCnt + minCnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
