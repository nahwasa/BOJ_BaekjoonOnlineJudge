import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    int n, num = 1;
    int[] bit, mapping, rangeEnd, salary;
    ArrayList<Integer>[] sub;

    private int query(int idx) {
        idx = mapping[idx];
        int sum = 0;
        while (idx > 0) {
            sum += bit[idx];
            idx -= idx&-idx;
        }
        return sum;
    }

    private void update(int idx, int diff) {
        while (idx <= n) {
            bit[idx] += diff;
            idx += idx&-idx;
        }
    }

    private void rangeUpdate(int s, int e, int diff) {
        update(s, diff);
        update(e+1, -diff);
    }

    private void rangeUpdate(int idx, int diff) {
        int s = mapping[idx];
        int e = rangeEnd[s];
        if (e == 0)
            return;
        rangeUpdate(s+1, e, diff);
    }

    private int initNumAndRange(int idx) {
        int end = (mapping[idx] = num++);
        if (sub[idx] == null)
            return end;

        for (int next : sub[idx]) {
            end = initNumAndRange(next);
        }
        rangeEnd[mapping[idx]] = end;
        return end;
    }

    private void initBIT() {
        for (int i = 1; i <= n; i++) {
            rangeUpdate(mapping[i], mapping[i], salary[i]);
        }
    }

    private void init(int n) {
        this.n = n;
        sub = new ArrayList[n+1];
        salary = new int[n+1];
        mapping = new int[n+1];
        rangeEnd = new int[n+1];
        bit = new int[n+1];
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        init(Integer.parseInt(st.nextToken()));
        int m = Integer.parseInt(st.nextToken());

        salary[1] = Integer.parseInt(br.readLine());
        for (int i = 2; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            salary[i] = Integer.parseInt(st.nextToken());
            int cur = Integer.parseInt(st.nextToken());
            if (sub[cur] == null)
                sub[cur] = new ArrayList<>();
            sub[cur].add(i);
        }

        initNumAndRange(1);
        initBIT();

        StringBuilder sb = new StringBuilder();
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken().charAt(0)) {
                case 'p':
                    rangeUpdate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                    break;
                case 'u':
                    sb.append(query(Integer.parseInt(st.nextToken()))).append('\n');
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
