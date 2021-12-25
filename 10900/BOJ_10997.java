import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int[] DR = {0,  1, 0, -1};
    private static final int[] DC = {-1, 0, 1,  0};

    private int[][] makeStarArr(int n) {
        int[][] arr = new int[3+4*(n-1)][1+4*(n-1)];
        int r = 0;
        int c = arr[0].length-1;
        arr[r][c] = 1;

        while (true) {
            for (int i = 0; i < 4; i++) {
                int cnt = 0;
                while (true) {
                    if (r+DR[i]<0 || r+DR[i]>=arr.length || c+DC[i]<0 || c+DC[i]>=arr[0].length) break;
                    if (r+2*DR[i]>=0 && r+2*DR[i] < arr.length && c+2*DC[i]>=0 && c+2*DC[i] < arr[0].length && arr[r+2*DR[i]][c+2*DC[i]] == 1) break;
                    r += DR[i];
                    c += DC[i];
                    cnt++;
                    arr[r][c] = 1;
                }
                if (cnt == 0)
                    return arr;
            }
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println("*");
            return;
        }

        int[][] arr = makeStarArr(n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == 1) {
                sb.append('*').append('\n');
                continue;
            }
            for (int j = 0; j < arr[0].length; j++) {
                sb.append(arr[i][j] == 1 ? '*':' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
