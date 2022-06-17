import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        StringBuilder sb = new StringBuilder();
        while (true) {
            s = br.readLine();
            if (s.equals("*")) break;
            int cnt = 0;
            int[] arr = new int['Z'-'A'+1];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c<'a' || c>'z') continue;
                if (++arr[c-'a']==1) cnt++;
            }
            sb.append(cnt==26?'Y':'N').append('\n');
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
