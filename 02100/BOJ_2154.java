import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(i);
        System.out.println(sb.toString().indexOf(String.valueOf(n))+1);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
