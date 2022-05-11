import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int tmp = n;
        int cnt = 0;
        do {
            cnt++;
            int a = (tmp/10)%10;
            int b = tmp%10;
            tmp = b*10+(a+b)%10;
        } while (tmp != n);
        bw.write(cnt+"");
        bw.flush();
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
