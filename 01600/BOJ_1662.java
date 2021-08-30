import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static String s;
    private static int idx = -1;

    private static int f() {
        int sum = 0;
        while (++idx < s.length()) {
            switch (s.charAt(idx)) {
                case '(' :
                    sum--;
                    int mult = s.charAt(idx-1)-'0';
                    sum += mult * f();
                    break;
                case ')' :
                    return sum;
                default :
                    sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        System.out.println(f());
    }
}
