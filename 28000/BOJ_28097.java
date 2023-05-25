import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int sum = (n-1)*8;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-->0) sum += Integer.parseInt(st.nextToken());

        System.out.println(sum/24 + " " + sum%24);
    }
}
