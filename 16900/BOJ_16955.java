import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    char[][] arr;

    private boolean chk(int r, int c) {
        // horizon chk
        int cnt = 0;
        for (int i = c-1; i >= 0 && arr[r][i] == 'X'; i--) cnt++;
        for (int i = c+1; i < 10 && arr[r][i] == 'X'; i++) cnt++;
        if (cnt >= 4) return true;

        // vertical chk
        cnt = 0;
        for (int i = r-1; i >= 0 && arr[i][c] == 'X'; i--) cnt++;
        for (int i = r+1; i < 10 && arr[i][c] == 'X'; i++) cnt++;
        if (cnt >= 4) return true;

        // '/' diagonal chk
        cnt = 0;
        for (int i = r+1, j = c-1; i<10&&j>=0 && arr[i][j] == 'X'; i++, j--) cnt++;
        for (int i = r-1, j = c+1; i>=0&&j<10 && arr[i][j] == 'X'; i--, j++) cnt++;
        if (cnt >= 4) return true;

        // '\' diagonal chk
        cnt = 0;
        for (int i = r+1, j = c+1; i<10&&j<10 && arr[i][j] == 'X'; i++, j++) cnt++;
        for (int i = r-1, j = c-1; i>=0&&j>=0 && arr[i][j] == 'X'; i--, j--) cnt++;
        if (cnt >= 4) return true;

        return false;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[10][10];
        for (int i = 0; i < 10; i++) {
            String s = br.readLine();
            for (int j = 0; j < 10; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j] != '.') continue;
                if (chk(i, j)) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
