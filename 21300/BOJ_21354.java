import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = 7*Integer.parseInt(st.nextToken());
        int b = 13*Integer.parseInt(st.nextToken());

        System.out.println(a==b?"lika" : (a>b?"Axel" : "Petra"));
    }
}
