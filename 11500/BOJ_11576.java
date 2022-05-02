import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int num = 0;
        int tmp = 1;
        for (int i = 0; i < m-1; i++) tmp *= a;
        st = new StringTokenizer(br.readLine());
        while (m-->0) {
            int cur = Integer.parseInt(st.nextToken());
            num += tmp*cur;
            tmp/=a;
        }
        String res = Integer.toString(num, b);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length(); i++) {
            char c = res.charAt(i);
            sb.append(c>'9'?c-'a'+10:c-'0').append(' ');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
