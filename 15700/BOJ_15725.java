import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int answer = 10001;

        if (s.charAt(0)=='x') {
            answer = 1;
        } else if (s.charAt(0)=='-' && s.charAt(1)=='x') {
            answer = -1;
        } else if (s.indexOf('x') == -1) {
            answer = 0;
        }

        if (answer != 10001) {
            System.out.println(answer);
            return;
        }

        int x = s.indexOf('x');
        String ans = "";
        for (int i = x-1; i >= 0; i--) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                ans = s.charAt(i) + ans;
                break;
            }
            ans = s.charAt(i) + ans;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
