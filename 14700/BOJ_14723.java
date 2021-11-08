import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int base = 1;
        int comp = 1;
        while (true) {
            if (n <= comp) break;
            comp += ++base;
        }
        int idx = base - (comp - n) - 1;
        System.out.println((base-idx) + " " + (idx+1));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
