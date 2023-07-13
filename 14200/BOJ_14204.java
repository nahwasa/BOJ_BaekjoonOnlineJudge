import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    int r, c;
    int[][] arr;

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 0; j < c; j++) {
            int columnIdx = columnInclude(j+1);
            if (columnIdx < j) {
                System.out.println(0);
                return;
            }

            swapColumn(j, columnIdx);
        }

        Set<Integer> exist = new HashSet<>();
        for (int i = 0; i < r; i++) {
            int rowIdx = rowInclude(i*c+1);
            if (rowIdx < i) {
                System.out.println(0);
                return;
            }

            swapRow(i, rowIdx);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] != i*c+j+1) {
                    System.out.println(0);
                    return;
                }
            }
        }

        System.out.println(1);
    }

    private void swapColumn(final int j, final int includeIdx) {
        for (int i = 0; i < r; i++) {
            int tmp = arr[i][j];
            arr[i][j] = arr[i][includeIdx];
            arr[i][includeIdx] = tmp;
        }
    }

    private void swapRow(final int i, final int includeIdx) {
        for (int j = 0; j < c; j++) {
            int tmp = arr[i][j];
            arr[i][j] = arr[includeIdx][j];
            arr[includeIdx][j] = tmp;
        }
    }

    private int columnInclude(final int find) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == find) return j;
            }
        }
        return -1;
    }

    private int rowInclude(final int find) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == find) return i;
            }
        }
        return -1;
    }
}
