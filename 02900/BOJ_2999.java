import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        System.out.println(main.solution(br.readLine()));
    }

    public String solution(String msg) throws Exception {
        int c = getC(msg.length());
        int r = msg.length()/c;

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++) {
                sb.append(msg.charAt(i*c+j));
            }
        }
        return sb.toString();
    }

    private int getC(int len) {
        for (int i = (int) Math.sqrt(len); i >= 1; i--)
            if (len%i==0) return i;
        return 0;
    }
}
