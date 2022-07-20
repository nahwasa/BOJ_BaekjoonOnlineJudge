import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Dir {
    int gap;
    ArrayList<Integer> st;
    public Dir(int n, int gap) {
        this.gap = gap;
        st = new ArrayList<>(n);
    }
    public void addSt(int a) {st.add(a);}
}
public class Main {
    private static final int COUNT_LIMIT = 5;
    Dir[] dir = new Dir[4];
    int n, answer = 0;
    int[] arr;
    private void init(int n) {
        dir[0] = new Dir(n, -1);    for (int i = 1; i <= n; i++)            dir[0].addSt(n*i-1);
        dir[1] = new Dir(n, 1);     for (int i = 0; i < n; i++)             dir[1].addSt(n*i);
        dir[2] = new Dir(n, -n);        for (int i = n*(n-1); i < n*n; i++)     dir[2].addSt(i);
        dir[3] = new Dir(n, n);         for (int i = 0; i < n; i++)             dir[3].addSt(i);
    }
    private void setMax() {
        for (int i = 0; i < n*n; i++) answer = Math.max(answer, arr[i]);
    }
    private void bf(int cnt) {
        if (cnt == COUNT_LIMIT) {
            setMax();
            return;
        }
        int[] arrTmp = arr;
        for (int i = 0; i < 4; i++) {
            int gap = dir[i].gap;
            int[] tmp = Arrays.copyOf(arr, arr.length);
            boolean[] dupChk = new boolean[n*n];
            int moveCnt = -1;
            while (moveCnt != 0) {
                moveCnt = 0;
                for (int cur : dir[i].st) {
                    for (int j = 0; j < n - 1; j++) {
                        if (tmp[cur] == 0 && tmp[cur + gap] != 0) {
                            tmp[cur] = tmp[cur + gap];
                            tmp[cur + gap] = 0;
                            dupChk[cur] = dupChk[cur + gap];
                            moveCnt++;
                        } else if (tmp[cur] != 0 && tmp[cur] == tmp[cur + gap] && !dupChk[cur] && !dupChk[cur + gap]) {
                            tmp[cur + gap] = 0;
                            tmp[cur] *= 2;
                            dupChk[cur] = true;
                            moveCnt++;
                        }
                        cur += gap;
                    }
                }
            }
            arr = tmp;
            bf(cnt+1);
            arr = arrTmp;
        }
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        init(n);
        arr = new int[n*n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) arr[i*n+j] = Integer.parseInt(st.nextToken());
        }
        bf(0);
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
