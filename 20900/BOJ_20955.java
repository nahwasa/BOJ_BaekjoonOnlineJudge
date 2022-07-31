import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private int[] parents;
  
    private void init(int n) {
        parents = new int[n+1];
        Arrays.fill(parents, -1);
    }
  
    private int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }
  
    private boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        int h = parents[a]<parents[b]?a:b;
        int l = parents[a]<parents[b]?b:a;
        parents[h]+=parents[l];
        parents[l] = h;
        return true;
    }
  
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        init(n);

        int cnt = 0;
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (!union(u, v)) cnt++;
        }
        for (int i = 1; i <= n; i++) {
            if (parents[i]<0) cnt++;
        }
        System.out.println(--cnt);
    }
  
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
