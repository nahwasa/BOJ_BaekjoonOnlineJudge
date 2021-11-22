import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private boolean isLegal(String str) {
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '>') cnt1++;
            else cnt2++;
            if (cnt2>cnt1) return false;
        }
        if (cnt1!=cnt2) return false;
        return true;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            sb.append(isLegal(st.nextToken()) ? "legal" : "illegal").append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
