import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private int pow5(int n) {
        return n*n*n*n*n;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sum = 0;
        for (int i = 0; i < s.length(); i++)
            sum += pow5(s.charAt(i)-'0');
        System.out.println(sum);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
