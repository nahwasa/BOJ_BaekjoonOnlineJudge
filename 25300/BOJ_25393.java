import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    HashMap<Integer, TreeSet<Integer>> left = new HashMap<>();
    HashMap<Integer, TreeSet<Integer>> right = new HashMap<>();

    private int getAnswer(int l, int r) {
        if (!left.containsKey(l) || !right.containsKey(r))
            return -1;

        Integer tmp = left.get(l).ceiling(r);
        if (tmp == null)
            return -1;
        else if (tmp == r)
            return 1;

        tmp = right.get(r).floor(l);
        if (tmp == null)
            return -1;
        return 2;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (n-->0) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (!left.containsKey(l))
                left.put(l, new TreeSet<>());
            left.get(l).add(r);
            if (!right.containsKey(r))
                right.put(r, new TreeSet<>());
            right.get(r).add(l);
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while (q-->0) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            answer.append(getAnswer(l, r)).append('\n');
        }
        System.out.print(answer);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
