import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String>[] hs = new HashSet[501];
        for (int i = 1; i <= 500; i++) hs[i] = new HashSet<>();
        while (n-->0) {
            String cur = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cur.length(); i++) {
                sb.append(cur.charAt(i));
                hs[sb.length()].add(sb.toString());
            }
        }
        int cnt = 0;
        while (m-->0) {
            String cur = br.readLine();
            if (hs[cur.length()].contains(cur))
                cnt++;
        }
        System.out.println(cnt);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
