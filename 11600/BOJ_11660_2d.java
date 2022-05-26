import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private void setLine() throws Exception { st = new StringTokenizer(br.readLine()); }
    private int ni() { return Integer.parseInt(st.nextToken()); }
    private int get2dRangeSum(int[][] arr, int x1, int y1, int x2, int y2) {
        return arr[x2][y2]-arr[x1-1][y2]-arr[x2][y1-1]+arr[x1-1][y1-1];
    }
    private void solution() throws Exception {
        setLine();
        int n = ni();
        int m = ni();
        int[][] arr = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            setLine();
            for (int j = 1; j <= n; j++)
                arr[i][j] = ni()+arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
        }
        StringBuilder sb = new StringBuilder();
        while(m-->0) {
            setLine();
            sb.append(get2dRangeSum(arr, ni(), ni(), ni(), ni())).append('\n');
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
