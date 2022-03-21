import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    int arr;
    ArrayList<Integer> piece;
    int n;
    int answer = Integer.MAX_VALUE;

    private boolean chk() {
        for (int i = 0; i < 25; i++) {
            int start = (int)(Math.log10(arr&-arr)/Math.log10(2));
            int r = start/5;
            int c = start%5;

            Stack<int[]> stk = new Stack<>();
            stk.add(new int[]{r,c});
            boolean[][] v = new boolean[5][5];
            v[r][c] = true;
            int cnt = 0;
            while (!stk.isEmpty()) {
                int[] cur = stk.pop();
                cnt++;
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        if (((dr^dc)&1)!=1) continue;
                        int nr = cur[0]+dr;
                        int nc = cur[1]+dc;
                        if (nr<0||nr>=5||nc<0||nc>=5||v[nr][nc]||(arr&(1<<nr*5+nc))==0) continue;
                        v[nr][nc] = true;
                        stk.push(new int[]{nr, nc});
                    }
                }
            }
            if (cnt == n) return true;
            return false;
        }
        return false;
    }

    private void bf(int idx, int sum) {
        if (answer <= sum) return;
        if (idx == n) {
            if (chk())
                answer = sum;
            return;
        }

        for (int i = 0; i < 25; i++) {
            if ((arr&1<<i)!=0) continue;
            int dist = Math.abs(piece.get(idx)/5-i/5) + Math.abs(piece.get(idx)%5-i%5);
            arr|=1<<i;
            bf(idx+1, sum+dist);
            arr^=1<<i;
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        piece = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String row = br.readLine();
            for (int j = 0; j < 5; j++) {
                if (row.charAt(j) == '*')
                    piece.add(i*5+j);
            }
        }
        n = piece.size();
        bf(0, 0);
        System.out.println(answer);
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
