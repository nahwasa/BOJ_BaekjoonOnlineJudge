import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashSet<String> hs = new HashSet<>();
        int[] cnt = new int[4];
        for (int i = 0; i < str.length(); i+=3) {
            String cur = str.substring(i, i+3);
            if (hs.contains(cur)) {
                System.out.println("GRESKA");
                return;
            }
            hs.add(cur);

            switch (cur.charAt(0)) {
                case 'P' : cnt[0]++; break;
                case 'K' : cnt[1]++; break;
                case 'H' : cnt[2]++; break;
                case 'T' : cnt[3]++; break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(13-cnt[i]).append(' ');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
