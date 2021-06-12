import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= N; tc++) {
            int[] alp = new int['z'-'a'+1];
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++)    alp[s.charAt(i)-'a']++;
            s = br.readLine();
            for (int i = 0; i < s.length(); i++)    alp[s.charAt(i)-'a']--;

            int cnt = 0;
            for (int i = 0; i < alp.length; i++)    cnt+=Math.abs(alp[i]);
            sb.append(String.format("Case #%d: %d\n", tc, cnt));
        }
        System.out.println(sb);
    }
}
