import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    HashMap<String, ArrayList<String>> edges;

    private boolean bf(String cur, String ed) {
        if (cur.equals(ed)) {
            return true;
        }
        if (edges.get(cur) == null)
            return false;
        for (String next : edges.get(cur)) {
            if (bf(next, ed))
                return true;
        }
        return false;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        edges = new HashMap<>();
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if (!edges.containsKey(a)) {
                edges.put(a, new ArrayList<>());
            }
            edges.get(a).add(b);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        System.out.println(bf(a, b) || bf(b, a) ? 1 : 0);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
