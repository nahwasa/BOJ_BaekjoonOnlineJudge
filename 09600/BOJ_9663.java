import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[][] v;
    private static int n, cnt;

    private static void put(int r, int c) {
        for (int i = 0; i < n; i++) {
            if(v[r][i] == -1)   v[r][i] = r; //가로
            if(v[i][c] == -1)   v[i][c] = r; //세로
            int tmp = c+r-i;
            if (tmp >= 0 && tmp < n && v[i][tmp] == -1)    v[i][tmp] = r;   // '/' 대각
            tmp = c-r+i;
            if (tmp >= 0 && tmp < n && v[i][tmp] == -1)    v[i][tmp] = r;   // '\' 대각
        }
    }

    private static void remove(int row) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (v[i][j] == row) v[i][j] = -1;
    }

    private static void f(int row) {
        if (row == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (v[row][i] >= 0)  continue;

            put(row, i);
            f(row+1);
            remove(row);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        v = new int[n][n];
        for (int[] row : v) Arrays.fill(row, -1);
        f(0);
        System.out.println(cnt);
    }
}
