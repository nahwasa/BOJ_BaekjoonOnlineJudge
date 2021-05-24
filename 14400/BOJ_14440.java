import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int a1 = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken()) - 1;
        int tmp = 0;
        while (n-->0) {
            tmp = (a1 * x + a0 * y) % 100;
            a0 = a1;
            a1 = tmp;
        }
        String res = String.valueOf(tmp);
        System.out.println(res.length()==1 ? "0"+res : res);
    }
}
