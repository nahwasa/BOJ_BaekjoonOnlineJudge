import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int even=0, odd=0;
        while (n-->0) {
            int cur = Integer.parseInt(st.nextToken());
            even+=1-cur&1;
            odd+=cur&1;
        }
        System.out.println(even>odd?"Happy":"Sad");
    }
}
