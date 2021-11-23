import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int MAX = 1003001;
    boolean[] arr;

    private boolean isPalindrome(int pn) {
        String tmp = String.valueOf(pn);
        for (int i = 0; i < tmp.length()/2; i++) {
            if (tmp.charAt(i) != tmp.charAt(tmp.length()-1-i))
                return false;
        }
        return true;
    }

    private void initPnAndPalindrome() {
        arr = new boolean[MAX+1];
        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            int base = i;
            while ((base+=i) <= MAX) {
                arr[base] = true;
            }
        }

        for (int i = 2; i < arr.length; i++) {
            if (!arr[i] && !isPalindrome(i)) {
                arr[i] = true;
            }
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) n = 2;
        initPnAndPalindrome();
        for (int i = n; i < arr.length; i++) {
            if (!arr[i]) {
                System.out.println(i);
                return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
