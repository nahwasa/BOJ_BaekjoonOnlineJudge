import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
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

        char[][] answer = new char[r][c];
        for (int i = 0; i < r; i++) Arrays.fill(answer[i], '.');
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 && j == 0) {
                    answer[i][j] = arr[i][j];
                    continue;
                }
                if (i == 0) {
                    if (arr[i][j] == '#' || arr[i][j-1] == '#')
                        answer[i][j] = '#';
                    continue;
                }
                if (j == 0) {
                    if (arr[i][j] == '#' || arr[i-1][j] == '#')
                        answer[i][j] = '#';
                    continue;
                }
                if (arr[i][j] == '#' || arr[i][j-1] == '#' || arr[i-1][j] == '#' || arr[i-1][j-1] == '#')
                    answer[i][j] = '#';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(answer[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
