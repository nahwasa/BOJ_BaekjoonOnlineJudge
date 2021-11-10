import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = -1;
        String maxStr = null;
        while (true) {
            String s = br.readLine();
            String[] split = s.toLowerCase().split("[^a-z-]");
            for (String cur : split) {
                if (cur.equals("e-n-d")) {
                    System.out.println(maxStr.toLowerCase());
                    return;
                }
                if (max < cur.length()) {
                    max = cur.length();
                    maxStr = cur;
                }
            }
        }
    }
}
