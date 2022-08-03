import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        boolean firstOneChk = false;
        StringBuilder answer = new StringBuilder();
        for (int i = 49; i >= 0; i--) {
            boolean is1bit = (n&1l<<i) != 0;
            if (!firstOneChk && !is1bit) continue;
            firstOneChk = true;
            answer.append(is1bit?1:0);
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
