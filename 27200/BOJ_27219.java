import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        new Main().solution(n);
    }

    public void solution(int n) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n/5; i++)
            sb.append('V');
        for (int i = 0; i < n%5; i++)
            sb.append('I');
        System.out.println(sb);
    }
}
