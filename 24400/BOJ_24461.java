import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[n];
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        for (int i = 0; i < n; i++) edges.put(i, new HashSet<>());

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            cnt[a]++;
            cnt[b]++;
            edges.get(a).add(b);
            edges.get(b).add(a);
        }

        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> remain = new HashSet<>();
        int remainCnt = 0;
        int exceptionChk = 0;
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 1) q.add(i);
            else if (cnt[i] == 2) exceptionChk++;
            else if (cnt[i] >= 3) {
                remain.add(i);
                remainCnt++;
            }
        }


        while (remainCnt!=0) {
            if (remainCnt == 1 && exceptionChk == 0) {   // exception case
                System.out.println(remain.iterator().next());
                return;
            }

            Queue<Integer> next = new ArrayDeque<>();

            while (!q.isEmpty()) {
                int cur = q.poll();
                int opposite = edges.get(cur).iterator().next();

                cnt[cur]--;
                if (cnt[cur] == 1) exceptionChk--;
                if (cnt[cur] == 2) exceptionChk++;

                cnt[opposite]--;

                if (cnt[opposite] == 1) {
                    exceptionChk--;
                    next.add(opposite);
                }
                if (cnt[opposite] == 2) exceptionChk++;
                if (cnt[opposite] < 3 && remain.contains(opposite)) {
                    remain.remove(opposite);
                    remainCnt--;
                }

                edges.get(opposite).remove(cur);
            }
            q = next;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            if (cnt[i] > 0) sb.append(i).append(' ');
        System.out.println(sb);
    }
}
