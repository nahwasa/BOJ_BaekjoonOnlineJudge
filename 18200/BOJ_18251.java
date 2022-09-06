import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private int getK(int n) {
        int k = 1;
        while ((n/=2)!=1) {
            k++;
        }
        return k;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<17);
        int n = Integer.parseInt(br.readLine()) + 1;
        int k = getK(n);
        int[] arr = new int[n];
        ArrayList<Integer>[] depth = new ArrayList[k];
        for (int i = 0; i < k; i++) depth[i] = new ArrayList<>(1<<i);

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, n/2});
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            depth[cur[0]].add(cur[1]);
            arr[cur[1]] = Integer.parseInt(st.nextToken());
            if (cur[0] == k-1) continue;

            q.add(new int[]{cur[0]+1, cur[1]-(1<<(k-2-cur[0]))});
            q.add(new int[]{cur[0]+1, cur[1]+(1<<(k-2-cur[0]))});
        }

        long answer = Long.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            for (int j = i; j < k; j++) {
                HashSet<Integer> hs = new HashSet<>();
                for (int s = i; s <= j; s++) {
                    ArrayList<Integer> depthList = depth[s];
                    for (int t = 0; t < depthList.size(); t++) {
                        hs.add(depthList.get(t));
                    }
                }

                long sum = 0;
                for (int x = 1; x < n; x++) {
                    if (!hs.contains(x)) continue;
                    sum+=arr[x];
                    if (sum > answer) answer = sum;
                    if (sum < 0) {
                        sum = 0;
                        continue;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
