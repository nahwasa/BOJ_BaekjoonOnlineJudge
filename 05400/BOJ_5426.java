import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            String encoded = br.readLine();
            sb.append(decode(encoded)).append('\n');
        }
        System.out.print(sb);
    }

    private String decode(String encoded) {
        int len = (int) Math.sqrt(encoded.length());

        StringBuilder result = new StringBuilder();
        for (int j = len-1; j >= 0; j--) {
            for (int i = 0; i < len; i++) {
                result.append(encoded.charAt(i*len+j));
            }
        }
        return result.toString();
    }
}
