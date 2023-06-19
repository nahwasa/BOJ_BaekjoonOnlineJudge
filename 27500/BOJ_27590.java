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
        int a = -Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[5001];
        while (a<0) a+=b;
        while (a<=5000) {
            arr[a] = true;
            a+=b;
        }

        st = new StringTokenizer(br.readLine());
        a = -Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        while (a<0) a+=b;
        while (a<=5000) {
            if (arr[a]) {
                System.out.println(a);
                return;
            }
            a+=b;
        }
    }
}
