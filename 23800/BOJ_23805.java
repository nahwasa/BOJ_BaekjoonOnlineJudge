import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    StringBuilder sb = new StringBuilder();
    private void print(char c, int cnt) {
        while (cnt-->0) sb.append(c);
    }
    private void br() {sb.append('\n');}
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            print('@', 3*n);
            print(' ', n);
            print('@', n);
            br();
        }
        for (int i = 0; i < 3*n; i++) {
            print('@', n);
            print(' ', n);
            print('@', n);
            print(' ', n);
            print('@', n);
            br();
        }
        for (int i = 0; i < n; i++) {
            print('@', n);
            print(' ', n);
            print('@', 3*n);
            br();
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
