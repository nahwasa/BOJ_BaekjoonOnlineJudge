import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            if (s == 0) {
                sb.append("0 0\n");
                continue;
            }

            if (a > s && b > s) {
                sb.append("Impossible\n");
                continue;
            }

            int hi = a>b?a:b;
            int lo = a>b?b:a;
            int limit = s/hi;
            boolean chk = false;
            boolean[] v = new boolean[lo];
            for (int i = limit; !chk && i >= 0; i--) {
                int remain = s - hi * i;
                int mod = remain%lo;
                if (v[mod]) {
                    chk = false;
                    break;
                }
                v[mod] = true;
                if (mod != 0) continue;

                chk = true;
                if (hi == a) {
                    sb.append(i + " " + (remain/lo)).append('\n');
                } else {
                    sb.append((remain/lo) + " " + i).append('\n');
                }
            }
            if (!chk)
                sb.append("Impossible\n");
        }
        System.out.print(sb);
    }

    private int getMin(String hhmm) {
        String[] split = hhmm.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
