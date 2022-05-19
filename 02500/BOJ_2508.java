import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            char[][] arr = new char[r][c];
            for (int i = 0; i < r; i++) {
                String s = br.readLine();
                for (int j = 0; j < c; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }
            int cnt = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 2; j < c; j++) {
                    if (arr[i][j] != '<') continue;
                    if (arr[i][j-1] == 'o' && arr[i][j-2] == '>') cnt++;
                }
            }
            for (int i = 2; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (arr[i][j] != '^') continue;
                    if (arr[i-1][j] == 'o' && arr[i-2][j] == 'v') cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
