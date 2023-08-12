import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int p = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (p-->0) {
            String cur = br.readLine();
            int[] cnt = new int[8];

            for (int i = 0; i < cur.length()-2; i++) {
                String substr = cur.substring(i, i+3);
                switch (substr) {
                    case "TTT": cnt[0]++; break;
                    case "TTH": cnt[1]++; break;
                    case "THT": cnt[2]++; break;
                    case "THH": cnt[3]++; break;
                    case "HTT": cnt[4]++; break;
                    case "HTH": cnt[5]++; break;
                    case "HHT": cnt[6]++; break;
                    case "HHH": cnt[7]++; break;
                }
            }

            for (int tmp : cnt) sb.append(tmp).append(' ');
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
