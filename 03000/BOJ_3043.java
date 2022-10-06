import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Tank {
    int r, c, num;
    static int n = 1;
    public Tank(int r, int c) {
        this.r = r;
        this.c = c;
        this.num = n++;
    }
}

public class Main {
    private static final Character MOVE_DOWN    = 'D';
    private static final Character MOVE_UP      = 'U';
    private static final Character MOVE_LEFT    = 'L';
    private static final Character MOVE_RIGHT   = 'R';

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Tank[] arr = new Tank[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Tank(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        StringBuilder answer = new StringBuilder();
        int cnt = 0;

        // vertical
        Arrays.sort(arr, new Comparator<Tank>() {
            @Override
            public int compare(Tank o1, Tank o2) {
                return o1.r - o2.r;
            }
        });
        for (int i = 0; i < n; i++) {
            Tank cur = arr[i];
            int r = cur.r;
            int target = i+1;
            while (r>target) {
                cnt++;
                answer.append(cur.num).append(' ').append(MOVE_UP).append('\n');
                r--;
            }
            cur.r = r;
        }
        for (int i = n-1; i >= 0; i--) {
            Tank cur = arr[i];
            int r = cur.r;
            int target = i+1;
            while (r<target) {
                cnt++;
                answer.append(cur.num).append(' ').append(MOVE_DOWN).append('\n');
                r++;
            }
            cur.r = r;
        }

        // horizontal
        Arrays.sort(arr, new Comparator<Tank>() {
            @Override
            public int compare(Tank o1, Tank o2) {
                return o1.c - o2.c;
            }
        });
        for (int i = 0; i < n; i++) {
            Tank cur = arr[i];
            int c = cur.c;
            int target = i+1;
            while (c>target) {
                cnt++;
                answer.append(cur.num).append(' ').append(MOVE_LEFT).append('\n');
                c--;
            }
        }
        for (int i = n-1; i >= 0; i--) {
            Tank cur = arr[i];
            int c = cur.c;
            int target = i+1;
            while (c<target) {
                cnt++;
                answer.append(cur.num).append(' ').append(MOVE_RIGHT).append('\n');
                c++;
            }
        }

        // print answer
        System.out.println(cnt);
        System.out.print(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
