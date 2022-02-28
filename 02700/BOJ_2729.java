import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if (a.indexOf('1') == -1) a = "0";
            else a = a.substring(a.indexOf('1'));
            if (b.indexOf('1') == -1) b = "0";
            else b = b.substring(b.indexOf('1'));

            ArrayList<Integer> answer = new ArrayList<>();
            int len = Math.max(a.length(), b.length());
            int bit = 0;
            for (int i = 0; i < len; i++) {
                bit += a.length()-i-1<0?0:a.charAt(a.length()-i-1)-'0';
                bit += b.length()-i-1<0?0:b.charAt(b.length()-i-1)-'0';
                answer.add(bit%2);
                bit/=2;
            }
            if (bit == 1)
                answer.add(bit);

            for (int i = answer.size()-1; i >= 0; i--) {
                sb.append(answer.get(i));
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
