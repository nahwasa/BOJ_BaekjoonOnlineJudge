public class Main {
    static int[][] arr = new int[5][5]; // 1:colored, 0:none
    static boolean[][] chk;
    static boolean isA1toE5Bingo = false;
    static boolean isE1toA5Bingo = false;
    static boolean isHBingoEx = false;
    static boolean isVBingoEx = false;
    static int totalBingoCnt = 0;
    static int cnt = 0;

    private static void chkBingoLine() {
        int[] hSum = new int[5];    //horizontal.   if [n][5] == true means 'row' is bingo line
        int[] vSum = new int[5];    //vertical      if [5][n] == true means 'column' is bingo line
        int[] cSum = new int[2];    //0:A1 to E5, 1:E1 to A5
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < 5; k++) {
                hSum[i] += arr[i][k];
                vSum[i] += arr[k][i];
            }
            cSum[0] += arr[i][i];
            cSum[1] += arr[i][4-i];
        }

        chk = new boolean[6][6];
        totalBingoCnt = 0;
        isA1toE5Bingo = false;
        isE1toA5Bingo = false;
        if (cSum[0] == 5) {
            totalBingoCnt++;
            isA1toE5Bingo = true;
        }
        if (cSum[1] == 5) {
            totalBingoCnt++;
            isE1toA5Bingo = true;
        }
        isHBingoEx = false;
        isVBingoEx = false;


        for (int i = 0; i < 5; i++) {
            if (hSum[i] == 5) {
                isHBingoEx = true;
                totalBingoCnt++;
                for (int k = 0; k <= 5; k++) chk[i][k] = true;
            }
            if (vSum[i] == 5) {
                isVBingoEx = true;
                totalBingoCnt++;
                for (int k = 0; k <= 5; k++) chk[k][i] = true;
            }
            if (isA1toE5Bingo) {
                chk[i][i] = true;
            }
            if (isE1toA5Bingo) {
                chk[i][4-i] = true;
            }
        }
    }

    private static void chkValidArr() {
        // chk : B5
        // no matter : C5, C2

        // E5, A5
        if (arr[4][0]+arr[4][4]==1) return;
        // D1, D4
        if (arr[0][3]+arr[3][3]==1) return;
        // A2, A4
        if (arr[1][0]+arr[3][0]!=1) return;
        // D2
        int sum = 0; boolean cur = arr[1][3]==1; for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) sum+=arr[i][j];
        if ( (cur && sum>17) || (!cur && sum<=17) )  return;
        // C4
        sum = 0; cur = arr[3][2]==1; for (int i = 0; i < 5; i++) sum+=arr[i][2];
        if ( (cur && sum>3) || (!cur && sum<=3) )  return;

        // Bingo Line chk
        chkBingoLine();

        // C2
        if (!isE1toA5Bingo && !isA1toE5Bingo && !chk[2][5] && !chk[5][2])   return;
        // C1
        cur = arr[0][2]==1; if ( (cur && !isA1toE5Bingo) || (!cur && isA1toE5Bingo) ) return;
        // E4
        boolean isEx = isA1toE5Bingo || isE1toA5Bingo;
        cur = arr[3][4]==1; if ( (cur && !isEx) || (!cur && isEx) )    return;
        // A1
        cur = arr[0][0]==1; if ( (cur && isE1toA5Bingo) || (!cur && !isE1toA5Bingo) )    return;
        // B4
        isEx = chk[1][5] || chk[5][3];
        cur = arr[3][1]==1; if ( (cur && !isEx) || (!cur && isEx) )    return;
        // B1
        cur = arr[0][1]==1; boolean curBingo = chk[0][1];
        if ( (cur && curBingo) || (!cur && !curBingo) )    return;
        // B2
        cur = arr[1][1]==1; isEx = isVBingoEx && isHBingoEx && (isA1toE5Bingo || isE1toA5Bingo);
        if ( (cur && !isEx) || (!cur && isEx) ) return;
        // A3
        cur = arr[2][0]==1; curBingo = chk[2][0];
        if ( (cur && !curBingo) || (!cur && curBingo) )    return;
        // D3
        cur = arr[2][3]==1; sum = 0; for (int i = 0; i < 5; i++) sum += chk[5][i]?1:0;
        if ( (cur && sum < 2) || (!cur && sum >= 2) ) return;
        // E1
        cur = arr[0][4]==1; curBingo = chk[0][4];
        if ( (cur && !curBingo) || (!cur && curBingo) )    return;
        // E2
        cur = arr[1][4]==1; sum = 0; for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) sum += chk[i][j]?1:0;
        isEx = sum != 0 && sum % 2 == 0;
        if ( (cur && !isEx) || (!cur && isEx) ) return;
        // E3
        cur = arr[2][4]==1; sum = 25-sum;
        if ( (cur && sum < 10) || (!cur && sum >= 10) ) return;
        // B3
        cur = arr[2][1]==1; sum = 0; for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) sum += (arr[i][j]==1 && !chk[i][j]) ? 1 : 0;
        if ( (cur && sum < 5) || (!cur && sum >= 5) ) return;
        // D5
        cur = arr[4][3]==1;
        if ( (cur && totalBingoCnt < 3) || (!cur && totalBingoCnt >= 3) ) return;


        StringBuilder sb = new StringBuilder();
        sb.append("Solution ").append(cnt).append('\n');
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                sb.append(arr[i][j]==1 ? '#' : '.');
            }
            sb.append('\n');
        }
        System.out.println(sb);

        cnt++;
    }

    private static void makeArr(int r, int c) {
        if (c==5) {
            chkValidArr();
            return;
        }
        int nr = r+1;
        int nc = c;
        if (nr == 5) {
            nr = 0;
            nc++;
        }

        if (r==2 && c==2) {
            arr[r][c] = 1;
            makeArr(nr, nc);
        } else if (r==0 && c==1) {
            arr[r][c] = 1;
            makeArr(nr, nc);
        } else {
            arr[r][c] = 0;
            makeArr(nr, nc);
            arr[r][c] = 1;
            makeArr(nr, nc);
        }
    }

    public static void main(String[] args) throws Exception {
        makeArr(0, 0);
        chkValidArr();
    }
}
