import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            boolean[] chk = new boolean['z'-'a'+1];
            String s = br.readLine().toLowerCase();
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c < 'a' || c > 'z') continue;
                if (!chk[c-'a']) {
                    chk[c-'a'] = true;
                    cnt++;
                }
            }
            if (cnt == 'z'-'a'+1) {
                sb.append("pangram\n");
                continue;
            }
            sb.append("missing ");
            for (int i = 0; i < chk.length; i++)
                if (!chk[i])
                    sb.append((char) ('a' + i));
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
