import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int DOCU = 1;
    static final int VISITED = 2;

    static int r, c;
    static int[][] arr;
    static boolean[] key;

    private static int solve() throws Exception {
        int cnt = 0;

        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qc = new LinkedList<>();
        qr.add(0);
        qc.add(0);
        arr[0][0] = VISITED;

        Queue<Integer>[] closedDoorR = new LinkedList['Z'-'A'+1];
        Queue<Integer>[] closedDoorC = new LinkedList['Z'-'A'+1];
        for (int i = 0; i < closedDoorR.length; i++) {
            closedDoorR[i] = new LinkedList<Integer>();
            closedDoorC[i] = new LinkedList<Integer>();
        }

        while (!qr.isEmpty()) {
            int cr = qr.poll();
            int cc = qc.poll();

            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (((dr&1)^(dc&1)) == 0)
                        continue;

                    int nr = cr + dr;
                    int nc = cc + dc;
                    if (nr < 0 || nr > r+1 || nc < 0 || nc > c+1 || arr[nr][nc] == VISITED)
                        continue;

                    int nval = arr[nr][nc];
                    arr[nr][nc] = VISITED;

                    if (nval >= 'A' && nval <= 'Z' && !key[nval-'A']) {
                        closedDoorR[nval-'A'].add(nr);
                        closedDoorC[nval-'A'].add(nc);
                        continue;
                    }

                    if (nval == DOCU) {
                        cnt++;
                    }

                    if (nval >= 'a' && nval <= 'z') {
                        key[nval-'a'] = true;
                        while (!closedDoorR[nval-'a'].isEmpty()) {
                            qr.add(closedDoorR[nval-'a'].poll());
                            qc.add(closedDoorC[nval-'a'].poll());
                        }
                    }

                    qr.add(nr);
                    qc.add(nc);
                }
            }
        }
        return cnt;
    }

    private static void init() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        key = new boolean['Z'-'A'+1];
        Arrays.fill(key, false);

        arr = new int[r+2][c+2];
        for (int[] row : arr) {
            Arrays.fill(row, 0);
        }

        // make map
        for (int i = 1; i <= r; i++) {
            String row = br.readLine();
            for (int j = 1; j <= c; j++) {
                char c = row.charAt(j-1);
                switch (c) {
                    case '.' : break;
                    case '*' : arr[i][j] = VISITED; break;
                    case '$' : arr[i][j] = DOCU; break;
                    default :  arr[i][j] = row.charAt(j-1); break;    // door, key
                }
            }
        }

        // get exist key
        String keys = br.readLine();
        if (keys.charAt(0) == '0')
            return;
        for (int i = 0; i < keys.length(); i++)
            key[keys.charAt(i) - 'a'] = true;
    }

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            init();
            sb.append(solve()).append('\n');
        }
        System.out.println(sb);
    }
}
