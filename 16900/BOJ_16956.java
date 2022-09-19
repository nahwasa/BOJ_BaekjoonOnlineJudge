import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int[] DR = {1, -1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

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

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] != 'S') continue;
                
                for (int d = 0; d < 4; d++) {
                    int nr = i+DR[d];
                    int nc = j+DC[d];
                    if (nr<0||nr>=r||nc<0||nc>=c||arr[nr][nc]=='S') continue;
                    if (arr[nr][nc] == 'W') {
                        System.out.println(0);
                        return;
                    }
                    arr[nr][nc] = 'D';
                }
                
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append('1').append('\n');
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                answer.append(arr[i][j]);
            }
            answer.append('\n');
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
