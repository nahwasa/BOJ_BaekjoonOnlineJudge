import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Candidate {
    int r,c,gridNum;
    public Candidate(int r, int c, int gridNum) {
        this.r = r;
        this.c = c;
        this.gridNum = gridNum;
    }
}

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int[][] chk = new int[3][9];
    private int[][] answer = new int[9][9];
    private ArrayList<Candidate> candidate = new ArrayList<>();

    private void initUserInput() throws Exception {
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                int cur = line.charAt(j*2)-'0';
                int gridNum = i/3*3+j/3;

                if (cur == 0) {
                    candidate.add(new Candidate(i,j,gridNum));
                    continue;
                }
                answer[i][j] = cur;
                chk[0][i]|=1<<cur;
                chk[1][j]|=1<<cur;
                chk[2][gridNum]|=1<<cur;
            }
        }
    }

    private void printAnswer() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(answer[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private boolean search(int idx) {
        if (idx == candidate.size()) {
            return true;
        }

        Candidate cur = candidate.get(idx);
        for (int num = 1; num <= 9; num++) {
            if ( (chk[0][cur.r]&1<<num)!=0 || (chk[1][cur.c]&1<<num)!=0 || (chk[2][cur.gridNum]&1<<num)!=0 )
                continue;

            chk[0][cur.r]|=1<<num;
            chk[1][cur.c]|=1<<num;
            chk[2][cur.gridNum]|=1<<num;
            answer[cur.r][cur.c] = num;

            if (search(idx+1)) return true;

            chk[0][cur.r]&=~(1<<num);
            chk[1][cur.c]&=~(1<<num);
            chk[2][cur.gridNum]&=~(1<<num);
        }
        return false;
    }

    private void solution() throws Exception {
        initUserInput();
        search(0);
        printAnswer();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
