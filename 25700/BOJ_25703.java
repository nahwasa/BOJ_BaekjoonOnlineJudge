import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("int a;").append('\n');
        sb.append("int *ptr = &a;").append('\n');
        for (int i = 2; i <= n; i++) {
            sb.append("int ");
            for (int j = 0; j < i; j++) sb.append('*');
            sb.append("ptr").append(i).append(" = &ptr").append(i-1==1?"":i-1).append(';').append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
