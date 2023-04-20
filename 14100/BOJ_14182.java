import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String s = "";
        StringBuilder sb = new StringBuilder();
        while ( !(s = br.readLine()).equals("0") ) {
            int income = Integer.parseInt(s);
            int tax = 0;

            if (income > 5000000) {
                tax = 20;
            } else if (income > 1000000) {
                tax = 10;
            }

            sb.append(income * (100 - tax) / 100).append('\n');
        }

        System.out.print(sb);
    }
}
