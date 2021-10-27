import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), "-");
            String s = st.nextToken();
            int sum = (s.charAt(0)-'A') * 26*26 + (s.charAt(1)-'A')*26 + (s.charAt(2)-'A')*1;
            sum -= Integer.parseInt(st.nextToken());
            sum = Math.abs(sum);
            if (sum <= 100) System.out.println("nice");
            else System.out.println("not nice");
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
