import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String s = br.readLine();
        int[] cnt = new int['z'-'a'+1];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        boolean odd = false;
        boolean even = false;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 0) continue;
            if (cnt[i]%2 == 0) even = true;
            else odd = true;
        }

        System.out.println(odd&&even ? 2 : even ? 0 : 1);
    }
}
