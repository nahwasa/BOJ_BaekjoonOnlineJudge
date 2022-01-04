import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int MAX_NUM = 2000;
    private ArrayList<Integer>[] edge;
    private ArrayList<Integer> left, right;
    private int[] matched;
    private boolean[] v;

    private HashSet<Integer> findPn() {
        boolean[] pnChk = new boolean[MAX_NUM+1];
        for (int base = 3; base <= Math.sqrt(MAX_NUM); base+=2) {
            if (pnChk[base]) continue;
            int tmp = base+base;
            while (tmp <= MAX_NUM) {
                pnChk[tmp] = true;
                tmp+=base;
            }
        }

        HashSet<Integer> pn = new HashSet<>();
        for (int i = 3; i <= MAX_NUM; i+=2) {
            if (!pnChk[i])
                pn.add(i);
        }
        return pn;
    }

    private void findEdge() {
        edge = new ArrayList[left.size()];
        for (int i = 0; i < edge.length; i++)
            edge[i] = new ArrayList<>();

        // find prime numbers using eratosthenes sieve
        HashSet<Integer> pn = findPn();

        for (int i = 0; i < left.size(); i++) {
            int from = left.get(i);

            for (int j = 0; j < right.size(); j++) {
                int to = right.get(j);
                if (pn.contains(from+to))
                    edge[i].add(j);
            }
        }
    }

    private boolean matching(int from) {
        for (int i = 0; i < edge[from].size(); i++) {
            int to = edge[from].get(i);
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
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = -1;

        // separate even and odd numbers
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        while (n-->0) {
            int cur = Integer.parseInt(st.nextToken());
            if ((cur&1)==1) odd.add(cur);
            else even.add(cur);
            if (first == -1) first = cur;
        }

        if (even.size() != odd.size()) {
            System.out.println(-1);
            return;
        }

        // choice left side and right side
        left = (first&1)==1?odd:even;
        right = (first&1)==1?even:odd;

        // make edge (value compression)
        findEdge();

        // if someone have 0 edge, there's no answer.
        for (int i = 0; i < edge.length; i++) {
            if (edge[i].size() == 0) {
                System.out.println(-1);
                return;
            }
        }

        // bipartite matching
        matched = new int[right.size()];
        Arrays.fill(matched, -1);
        v = new boolean[right.size()];
        for (int i = 1; i < left.size(); i++) { // matching except 'first' number.
            if (!matching(i)) {
                System.out.println(-1);
                return;
            }

            v = new boolean[right.size()];
        }

        // find answer
        ArrayList<Integer> answer = new ArrayList<>(edge[0].size());

        for (int i = 0; i < edge[0].size(); i++) {
            int to = edge[0].get(i);

            if (matched[to] == -1 || matching(matched[to])) {
                matched[to] = -1;
                answer.add(right.get(to));
            }

            v = new boolean[right.size()];
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.size(); i++)
            sb.append(answer.get(i)).append(' ');

        System.out.println(answer.size() == 0 ? -1 : sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
