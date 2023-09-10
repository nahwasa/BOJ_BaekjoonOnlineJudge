import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        if (n>=1000 && (u>=8000 || l>=260)) {
            System.out.println("Very Good");
            return;
        }

        if (n>=1000) {
            System.out.println("Good");
            return;
        }

        System.out.println("Bad");
    }
}
