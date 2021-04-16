import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = b;
            for (int j = 1; j < n; j++) {
                b += Integer.parseInt(st.nextToken());
                arr[i][j] = b;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int[] tmp = new int[4];
            for (int i = 0; i < 4; i++) tmp[i] = Integer.parseInt(st.nextToken()) - 1;
            int sum = 0;
            for (int i = tmp[0]; i <= tmp[2]; i++) {
                sum += arr[i][tmp[3]] - (tmp[1]>0 ? arr[i][tmp[1]-1] : 0);
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}
