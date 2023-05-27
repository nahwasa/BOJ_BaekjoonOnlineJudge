import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        Map<String, String> translation = Map.ofEntries(
                Map.entry("CU", "see you"),
                Map.entry(":-)", "I’m happy"),
                Map.entry(":-(", "I’m unhappy"),
                Map.entry(";-)", "wink"),
                Map.entry(":-P", "stick out my tongue"),
                Map.entry("(~.~)", "sleepy"),
                Map.entry("TA", "totally awesome"),
                Map.entry("CCC", "Canadian Computing Competition"),
                Map.entry("CUZ", "because"),
                Map.entry("TY", "thank-you"),
                Map.entry("YW", "you’re welcome"),
                Map.entry("TTYL", "talk to you later")
        );

        StringBuilder sb = new StringBuilder();
        while (true) {
            String cur = br.readLine();

            sb.append(translation.getOrDefault(cur, cur)).append('\n');
            if (cur.equals("TTYL")) break;
        }

        System.out.print(sb);
    }
}
