import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final String msg1 = "A storm warning for tomorrow! Be careful and stay home if possible!";
    private static final String msg2 = "MCHS warns! Low temperature is expected tomorrow.";
    private static final String msg3 = "MCHS warns! Strong wind is expected tomorrow.";
    private static final String msg4 = "No message";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t1 = Integer.parseInt(st.nextToken());
        int v1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int t2 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        if (t2 < 0 && v2 >= 10) System.out.println(msg1);
        else if (t2 < t1) System.out.println(msg2);
        else if (v2 > v1) System.out.println(msg3);
        else System.out.println(msg4);
    }
}
