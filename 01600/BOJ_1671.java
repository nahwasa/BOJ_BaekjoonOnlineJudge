import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    class Shark {
        int a,b,c;
        public Shark(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public boolean canEat(Shark ano) {
            if (this.a>=ano.a && this.b>=ano.b && this.c>=ano.c)
                return true;
            return false;
        }
    }
    int[] matched;
    boolean[] v;
    ArrayList<Integer>[] edges;
    int n;
    private boolean matching(int from) {
        for (int i = 0; i < edges[from].size(); i++) {
            int to = edges[from].get(i);
            if (v[to]) continue;
            v[to] = true;
            if (matched[to] == -1 || matching(matched[to])) {
                matched[to] = from;
                return true;
            }
        }
        return false;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        edges = new ArrayList[n];
        matched = new int[n];
        Arrays.fill(matched, -1);
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        Shark[] arr = new Shark[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i] = new Shark(a,b,c);
            for (int j = 0; j < i; j++) {
                if (arr[i].canEat(arr[j]) && arr[j].canEat(arr[i])) edges[i].add(j);
                else if (arr[i].canEat(arr[j])) edges[i].add(j);
                else if (arr[j].canEat(arr[i])) edges[j].add(i);
            }
        }
        int cnt = 0;
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < n; i++) {
                v = new boolean[n];
                if (matching(i)) {
                    cnt++;
                }
            }
        }
        System.out.println(n-cnt);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
