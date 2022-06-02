import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (r*c==0) break;
            int[][] arr = new int[r][c];
            for (int i = 0; i < r; i++) {
                String row = br.readLine();
                for (int j = 0; j < c; j++) {
                    if (row.charAt(j) == '.') continue;
                    arr[i][j]=-1;
                    for (int a = i-1; a <= i+1; a++) {
                        for (int b = j-1; b <= j+1; b++) {
                            if (a<0||a>=r||b<0||b>=c||arr[a][b]==-1) continue;
                            arr[a][b]++;
                        }
                    }
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (arr[i][j]==-1) sb.append('*');
                    else sb.append(arr[i][j]);
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
