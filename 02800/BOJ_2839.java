import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int base = n/5+1;
        while (base-->0) {
            if ((n-base*5)%3==0) {
                System.out.println(base+(n-base*5)/3);
                return;
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
