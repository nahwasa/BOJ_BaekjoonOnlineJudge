import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    String s;
    boolean[] v;
    Set<Long> dupChk = new HashSet<>();
    int answer = 0;
    int[] compression;

    private void solution() throws Exception {
        s = br.readLine();
        v = new boolean[s.length()];
        initCompression();

        dfs(0, 1, '-');

        System.out.println(answer);
    }

    private void initCompression() {
        compression = new int['z'-'a'+1];

        Arrays.fill(compression,-1);
        for (int i = 0; i < s.length(); i++) compression[s.charAt(i)-'a']++;
        int comp = 0;
        for (int i = 0; i < compression.length; i++) {
            if (compression[i] != -1)
                compression[i] = comp++;
        }
    }

    private void dfs(final int idx, long cur, char bf) {
        if (idx == s.length()) {
            if (!dupChk.contains(cur)) {
                answer++;
                dupChk.add(cur);
            }

            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (v[i] || s.charAt(i) == bf) continue;

            v[i] = true;
            cur *= 10;
            cur += compression[ctoi(s.charAt(i))];
            dfs(idx+1, cur, s.charAt(i));
            cur /= 10;
            v[i] = false;
        }
    }

    private int ctoi(char c) {
        return c-'a';
    }
}
