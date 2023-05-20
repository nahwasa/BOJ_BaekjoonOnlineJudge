import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        n--;

        int a = n/8;
        int b = n%8;
        System.out.println((char)('a'+b)+""+(a+1));
    }
}
