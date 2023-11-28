import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    int r, c;
    char[][] arr;
    boolean[][] v;

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = row.charAt(j);
            }
        }

        v = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (v[i][j]) continue;

                int[] range = findRange(i, j);
                if (!possible(i, j, range[0], range[1])) {
                    System.out.println("BaboBabo");
                    return;
                }
            }
        }

        System.out.println("dd");
    }

    private boolean possible(final int rs, final int cs, final int re, final int ce) {
        char target = arr[rs][cs];
        for (int i = rs; i <= re; i++) {
            for (int j = cs; j <= ce; j++) {

                v[i][j] = true;
                if (arr[i][j] != target)
                    return false;

                if (i == rs && i-1 >= 0 && arr[i-1][j] == target)
                    return false;

                if (i == re && i+1 < r && arr[i+1][j] == target)
                    return false;

                if (j == cs && j-1 >= 0 && arr[i][j-1] == target)
                    return false;

                if (j == ce && j+1 < c && arr[i][j+1] == target)
                    return false;

            }
        }

        return true;
    }

    private int[] findRange(final int y, final int x) {
        char target = arr[y][x];

        int i = y;
        while (i < r && arr[i][x] == target) i++;
        int j = x;
        while (j < c && arr[y][j] == target) j++;

        return new int[]{i-1, j-1};
    }
}
