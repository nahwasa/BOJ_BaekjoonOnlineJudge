import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] chk = new boolean['Z'-'A'+1];
        while (st.hasMoreTokens()) {
            chk[st.nextToken().charAt(0)-'A'] = true;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            char cur = a.charAt(i);
            answer.append(cur<'a' && chk[cur-'A'] ? (char)(cur+('a'-'A')) : cur);
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
