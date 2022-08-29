import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (ts.last() >= cur) {
                ts.remove(ts.ceiling(cur));
            }
            ts.add(cur);
        }
        System.out.println(ts.size());
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
