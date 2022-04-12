import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        int max = 0;
        while (c-->0) {
            String cur = br.readLine();
            cur = cur.replaceAll("for", ",");
            cur = cur.replaceAll("while", ",");
            int cnt = 0;
            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) == ',')
                    cnt++;
            }
            max = max<cnt?cnt:max;
        }
        System.out.println(max);
    }
}
