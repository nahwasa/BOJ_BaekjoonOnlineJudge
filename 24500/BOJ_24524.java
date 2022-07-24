import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private boolean chk(int[] cnt, char[] t, int idx) {
        if (idx == 0) return true;
        return cnt[t[idx]-'a'] < cnt[t[idx-1]-'a'];
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        char[] t = br.readLine().toCharArray();
        HashMap<Character, Integer> mapping = new HashMap<>();
        for (int i = 0; i < t.length; i++) {
            mapping.put(t[i], i);
        }
        int[] cnt = new int[26];
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (!mapping.containsKey(c) || !chk(cnt, t, mapping.get(c))) continue;
            cnt[c-'a']++;
        }
        System.out.println(cnt[t[t.length-1]-'a']);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
