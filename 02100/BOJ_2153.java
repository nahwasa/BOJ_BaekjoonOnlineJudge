import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a') sum += 1+c-'a';
            else sum += 27+c-'A';
        }
        System.out.println(isPrime(sum)?"It is a prime word.":"It is not a prime word.");
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
