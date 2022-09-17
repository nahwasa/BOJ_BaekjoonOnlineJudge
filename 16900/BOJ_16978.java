import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    private int n;
    private int[] arr;
    private long[] bit;

    private void update(int idx, int diff) {
        while (idx <= n) {
            bit[idx] += diff;
            idx += idx&-idx;
        }
    }

    private long pSum(int idx) {
        long answer = 0l;
        while (idx > 0) {
            answer += bit[idx];
            idx -= idx&-idx;
        }
        return answer;
    }

    private long query(int a, int b) {
        return pSum(b) - pSum(a-1);
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<17);
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        bit = new long[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            update(i, arr[i]);
        }
        int m = Integer.parseInt(br.readLine());
        ArrayList<int[]> query1 = new ArrayList<>();
        query1.add(null);
        ArrayList<int[]> query2 = new ArrayList<>();
        int query2Idx = 0;
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            switch (op) {
                case 1 : query1.add(new int[]{a, b}); break;
                case 2 : query2.add(new int[]{a, b, Integer.parseInt(st.nextToken()), query2Idx++}); break;
            }
        }

        Collections.sort(query2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int bf = 0;
        long[] answer = new long[query2.size()];
        for (int[] cur : query2) {
            if (bf != cur[0]) {
                for (int i = bf+1; i <= cur[0]; i++) {
                    int[] q = query1.get(i);
                    update(q[0], q[1] - arr[q[0]]);
                    arr[q[0]] = q[1];
                    bf = cur[0];
                }
            }
            answer[cur[3]] = query(cur[1], cur[2]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
