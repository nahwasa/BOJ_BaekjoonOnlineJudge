import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int chk = 1;
        int cnt = 0;
        while (n-->0) {
            if (Integer.parseInt(st.nextToken()) == chk)    chk++;
            else    cnt++;
        }
        System.out.println(cnt);
    }
}
