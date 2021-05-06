import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int cs = 1; cs <= n; cs++) {
            int[] cnt = new int['z'-'a'+1];
            String s = br.readLine().toLowerCase();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c < 'a' || c > 'z') continue;
                cnt[c-'a']++;
            }
            int min = 3;
            for (int i = 0; i < cnt.length; i++) {
                min = Math.min(min, cnt[i]);
            }
            String res = "Not a pangram";
            switch (min) {
                case 1 : res = "Pangram!"; break;
                case 2 : res = "Double pangram!!"; break;
                case 3 : res = "Triple pangram!!!"; break;
            }
            System.out.println(String.format("Case %d: %s", cs, res));
        }
    }
}
