import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dr = {0, 1, 0, -1};
    private static final int[] dc = {1, 0, -1, 0};

    private void add(int[][] arr, String msg) {
        int dir = 0;
        int cr = 1;
        int cc = 0;
        for (int i = 0; i < msg.length(); i++) {
            int c = msg.charAt(i)==' '?0:msg.charAt(i)-'A'+1;
            int bit = 5;
            while (bit-->0) {
                while (arr[cr+dr[dir]][cc+dc[dir]] != -1) {
                    dir++;
                    if (dir == 4)
                        dir = 0;
                }
                cr+=dr[dir];
                cc+=dc[dir];
                arr[cr][cc] = (c&1<<bit)!=0?1:0;
            }
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            String msg = str.substring((r>=10?2:1) + (c>=10?2:1) + 2);

            int[][] arr = new int[r+2][c+2];
            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    arr[i][j] = -1;
                }
            }
            add(arr, msg);
            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    sb.append(arr[i][j]==-1?0:arr[i][j]);
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
