import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private char getReverseChar(char c) {
        switch (c) {
            case '2': return '5';
            case '5': return '2';
            case '1': case '8': return c;
            default: return '?';
        }
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char w = st.nextToken().charAt(0);
        int n = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][n];
        boolean isLR = w=='L'||w=='R';
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[isLR?i:n-i-1][isLR?n-j-1:j] = getReverseChar(st.nextToken().charAt(0));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
