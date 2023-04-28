import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int d = 0;
        int p = 0;

        while (n-->0) {
            if (br.readLine().charAt(0) == 'D') d++;
            else p++;

            if (Math.abs(d-p) >= 2) {
                break;
            }
        }

        System.out.println(d + ":" + p);
    }
}
