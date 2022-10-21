import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private boolean isPalindrome(int n, int radix) {
        ArrayList<Integer> convert = new ArrayList<>();
        while (n != 0) {
            convert.add(n%radix);
            n/=radix;
        }
        for (int i = 0; i < convert.size()/2; i++) {
            if (convert.get(i) != convert.get(convert.size()-1-i))
                return false;
        }
        return true;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            int num = Integer.parseInt(br.readLine());
            boolean chk = false;
            for (int r = 2; r <= 64 && !chk; r++) {
                chk = isPalindrome(num, r);
            }
            sb.append(chk?1:0).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
