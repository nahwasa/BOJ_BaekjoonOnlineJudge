import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    static int find(int a) {
        if (parent[a] < 0)  return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        int h = a < b ? a : b;
        int l = a < b ? b : a;
        parent[h] += parent[l];
        parent[l] = h;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        Arrays.fill(parent, -1); parent[0] = -2;
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while (t-->0)   union(0, Integer.parseInt(st.nextToken()));
        String[] pt = new String[m];
        while (m-->0) {
            pt[m] = br.readLine();
            st = new StringTokenizer(pt[m]);
            if ((t = Integer.parseInt(st.nextToken())) == 0) break;
            int base = Integer.parseInt(st.nextToken());
            while (t-->1)   union(base, Integer.parseInt(st.nextToken()));
        }
        int cnt = 0;
        for (String s : pt) {
            st = new StringTokenizer(s);
            if ((t = Integer.parseInt(st.nextToken())) == 0) { cnt++; continue; }
            boolean isValid = true;
            while (t-->0)   if (find(Integer.parseInt(st.nextToken())) == 0)    { isValid = false; break; }
            if (isValid)    cnt++;
        }
        System.out.println(cnt);
    }
}
