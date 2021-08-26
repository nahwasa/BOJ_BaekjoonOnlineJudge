import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private final static String EVEN    = "Even";
    private final static String ODD     = "Odd";
    private final static String EITHER  = "Either";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println((n&1)==1 ? EITHER : ((n/2)&1)==1 ? ODD : EVEN);
    }
}
