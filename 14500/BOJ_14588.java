import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] pos = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }

        // make adjacent list
        int[][] adj = new int[n+1][n+1];
        for (int i = 1; i <= n; i++)
            Arrays.fill(adj[i], 301);
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                if ((pos[j][0] >= pos[i][0] && pos[j][0] <= pos[i][1])
                        || (pos[j][1] >= pos[i][0] && pos[j][1] <= pos[i][1])
                        || (pos[j][0] < pos[i][0] && pos[j][1] > pos[i][1])) {
                    adj[i][j] = adj[j][i] = 1;
                }
            }
        }
        pos = null;

        // floyd-washall
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }

        // result
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (q-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(adj[a][b] == 301 ? -1 : adj[a][b]).append('\n');
        }
        System.out.println(sb);
    }
}
