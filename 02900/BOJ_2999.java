import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        System.out.println(main.solution(br.readLine()));
    }

    public String solution(String msg) throws Exception {
        int r = getR(msg.length());
        int c = msg.length()/r;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(msg.charAt(j*r+i));
            }
        }
        return sb.toString();
    }

    private int getR(int len) {
        for (int i = (int) Math.sqrt(len); i >= 1; i--)
            if (len%i==0) return i;
        return 0;
    }
}
