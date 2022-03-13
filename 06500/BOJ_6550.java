import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str == null) break;
            StringTokenizer st = new StringTokenizer(str);
            String s = st.nextToken();
            String t = st.nextToken();

            int si = 0;
            int ti = 0;
            while (si < s.length()) {
                while (ti < t.length() && t.charAt(ti) != s.charAt(si)) ti++;
                if (ti < t.length() && s.charAt(si) == t.charAt(ti)) { si++; ti++; }
                else break;
            }
            sb.append(si == s.length() ? "Yes\n" : "No\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
