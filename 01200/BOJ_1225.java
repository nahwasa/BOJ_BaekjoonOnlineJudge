import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        long sum = 0l;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                sum += (a.charAt(i)-'0')*(b.charAt(j)-'0');
            }
        }
        System.out.println(sum);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
