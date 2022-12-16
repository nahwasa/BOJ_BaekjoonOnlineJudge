import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            if (st.nextToken().equals("9")) {
                System.out.println("F");
                return;
            }
        }
        System.out.println("S");
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
