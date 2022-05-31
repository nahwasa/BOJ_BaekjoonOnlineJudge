import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int getArea(int[][] arr, int r, int c) {
        int cnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                cnt += arr[i][j]>0?1:0;
            }
        }
        cnt*=2;

        for (int i = 0; i < r; i++) {
            int bf = 0;
            for (int j = 0; j < c; j++) {
                if (bf < arr[i][j]) cnt += arr[i][j]-bf;
                bf = arr[i][j];
            }
        }
        for (int i = 0; i < r; i++) {
            int bf = 0;
            for (int j = c-1; j >=0; j--) {
                if (bf < arr[i][j]) cnt += arr[i][j]-bf;
                bf = arr[i][j];
            }
        }
        for (int j = 0; j < c; j++) {
            int bf = 0;
            for (int i = 0; i < r; i++) {
                if (bf < arr[i][j]) cnt += arr[i][j]-bf;
                bf = arr[i][j];
            }
        }
        for (int j = 0; j < c; j++) {
            int bf = 0;
            for (int i = r-1; i >= 0; i--) {
                if (bf < arr[i][j]) cnt += arr[i][j]-bf;
                bf = arr[i][j];
            }
        }
        return cnt;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] arr = new int[r][c];
            for (int i = 0; i < r; i++) {
                String row = br.readLine();
                for (int j = 0; j < c; j++) {
                    arr[i][j] = row.charAt(j)-'0';
                }
            }
            sb.append(getArea(arr, r, c)).append('\n');
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
