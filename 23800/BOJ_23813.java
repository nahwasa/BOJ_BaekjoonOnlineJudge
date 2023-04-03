import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String str = br.readLine();
        int mult = 1;
        for (int i = 0; i < str.length()-1; i++) {
            mult *= 10;
        }
        int n = Integer.parseInt(str);

        long sum = 0;
        int next = n;
        do {
            sum += next;
            next = next/10 + next%10*mult;
        } while (next != n);

        System.out.println(sum);
    }
}
