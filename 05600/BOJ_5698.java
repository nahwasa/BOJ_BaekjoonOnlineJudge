import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        StringBuilder sb = new StringBuilder();
        while (!(s = br.readLine()).equals("*")) {
            StringTokenizer st = new StringTokenizer(s);
            char c = st.nextToken().charAt(0);
            if (c>='A' && c <='Z') c -= 'Z'-'z';
            boolean chk = true;
            while (st.hasMoreTokens()) {
                char tmp = st.nextToken().charAt(0);
                if (tmp>='A' && tmp <='Z') tmp -= 'Z'-'z';
                if (tmp != c) {
                    chk = false;
                    break;
                }
            }
            sb.append(chk?'Y':'N').append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
