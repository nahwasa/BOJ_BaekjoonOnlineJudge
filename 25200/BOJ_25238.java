import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        double tmp = a - a*(1d*b/100);
        System.out.println(tmp>=100?0:1);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
