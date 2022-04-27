import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    ArrayList<int[]> queen;
    int rowCnt, colCnt;
    private boolean chk(int i, int j) {
        // 세로 체크 (i가 2였다면 세로에서 처음 나온거라면 ..00000 -> ..00100, 두번째는 ..00100 -> ..00000 이 되므로 1<<i가 0이 됨.)
        if (((rowCnt^=1<<i)&1<<i)==0) return false;
        // 가로 체크 (위와 동일)
        if (((colCnt^=1<<j)&1<<j)==0) return false;
        // 대각선 체크 (x, y축 각각의 차이의 절대값이 동일하면 대각선 위치임)
        for (int k = 0; k < queen.size(); k++) {
            if (Math.abs(queen.get(k)[0]-i) == Math.abs(queen.get(k)[1]-j))
                return false;
        }
        queen.add(new int[]{i, j});
        return true;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        queen = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (s.charAt(j) != '*') continue;
                cnt++;
                if (!chk(i, j)) {
                    System.out.println("invalid");
                    return;
                }
            }
        }
        System.out.println(cnt==8?"valid":"invalid");
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
