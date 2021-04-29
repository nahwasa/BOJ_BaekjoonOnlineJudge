import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Vector<Vector<Integer>> arr = new Vector<>();
        for (int i = 0 ; i <= n; i++) arr.add(new Vector<>());
        int[] res = new int[n+1];
        boolean[] v = new boolean[n+1];
        while (--n>0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);   //add root
        v[1] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Integer next : arr.get(cur)) {
                if (v[next])    continue;
                v[next] = true;
                res[next] = cur;
                q.add(next);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < res.length; i++)    sb.append(res[i]).append('\n');
        System.out.print(sb);
    }
}
