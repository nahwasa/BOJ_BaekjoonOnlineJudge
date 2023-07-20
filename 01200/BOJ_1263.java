import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());

        ToDo[] arr = new ToDo[n];
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            arr[n] = new ToDo(t, s);
        }

        Arrays.sort(arr);

        int pt = 1000000;
        for (ToDo cur : arr) {
            pt = Math.min(pt, cur.s)-cur.t;
            if (pt < 0) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(pt);
    }
}

class ToDo implements Comparable<ToDo> {
    int t, s;

    public ToDo(int t, int s) {
        this.t = t;
        this.s = s;
    }

    @Override
    public int compareTo(final ToDo o) {
        return o.s-s;
    }
}
