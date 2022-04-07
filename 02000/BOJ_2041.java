import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        arr[0][0] = 1;
        int r = 0;
        int c = 0;
        boolean swt = true;
        int gap = 1;
        while (r!=n-1 || c!=m-1) {
            while (r>=0&&r<n&&c>=0&&c<m) {
                if (swt) {
                    if (r+1<n) arr[r+1][c] = arr[r][c]+gap++;
                    if (c+1<m) arr[r][c+1] = arr[r][c]+gap++;
                    if (r-1<0 || c+1>=m) {
                        if (c+1<m) c++;
                        else if (r+1<n) r++;
                        break;
                    }
                    r--;
                    c++;
                } else {
                    if (c+1<m) arr[r][c+1] = arr[r][c]+gap++;
                    if (r+1<n) arr[r+1][c] = arr[r][c]+gap++;
                    if (r+1>=n || c-1<0) {
                        if (r+1<n) r++;
                        else if (c+1<m) c++;
                        break;
                    }
                    r++;
                    c--;
                }
            }
            swt = !swt;
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer.append(arr[i][j]);
                if (j==m-1) answer.append('\n');
                else answer.append(' ');
            }
        }
        System.out.print(answer);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
