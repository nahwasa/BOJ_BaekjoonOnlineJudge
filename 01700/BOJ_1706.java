import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = row.charAt(j);
            }
        }

        String min = String.valueOf((char)('z'+1));
        for (int i = 0; i < r; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= c; j++) {
                if (j==c || arr[i][j] == '#') {
                    String tmp = sb.toString();
                    if (tmp.length() >= 2 && min.compareTo(tmp) > 0)
                        min = tmp;
                    sb = new StringBuilder();
                } else {
                    sb.append(arr[i][j]);
                }
            }
        }

        for (int j = 0; j < c; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= r; i++) {
                if (i==r || arr[i][j] == '#') {
                    String tmp = sb.toString();
                    if (tmp.length() >= 2 && min.compareTo(tmp) > 0)
                        min = tmp;
                    sb = new StringBuilder();
                } else {
                    sb.append(arr[i][j]);
                }
            }
        }
        System.out.println(min);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
