import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), "sb");
        int cnt = 0;
        while (n-->0) {
            cnt += st.nextToken().charAt(0) == 'e' ? 1 : -1;
        }

        if (cnt > 0) {
            System.out.println("security!");
        } else if (cnt < 0) {
            System.out.println("bigdata?");
        } else {
            System.out.println("bigdata? security!");
        }
    }
}
