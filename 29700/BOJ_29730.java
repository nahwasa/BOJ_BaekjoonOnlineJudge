import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    private static final int MAX = 10080;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());

        List<String> study = new ArrayList<>();
        List<Integer> boj = new ArrayList<>();
        while (n-->0) {
            String cur = br.readLine();
            if (cur.startsWith("boj.kr/")) {
                int num = -1;
                try {
                    num = Integer.parseInt(cur.substring(7));
                } catch (Exception e) {}

                if (num >= 1 && num <= 30000) {
                    boj.add(num);
                    continue;
                }
            }

            study.add(cur);
        }

        Collections.sort(study, (a, b)->{
            if (a.length() == b.length())
                return a.compareTo(b);
            return a.length() - b.length();
        });
        Collections.sort(boj);

        StringBuilder sb = new StringBuilder();
        for (String s : study) sb.append(s).append('\n');
        for (Integer num : boj) sb.append("boj.kr/").append(num).append('\n');
        System.out.print(sb);
    }
}
