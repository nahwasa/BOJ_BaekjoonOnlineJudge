import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    int n;
    String s;
    ArrayList<Integer>[] edges;

    private char getChar(int idx) {return s.charAt(idx-1);}
    private StringBuilder getAnswer() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();
        boolean[] v = new boolean[n+1];
        arr.add(1);
        v[1] = true;
        sb.append(getChar(1));
        while (!arr.isEmpty()) {
            ArrayList<Integer> validNodes = null;
            char max = '\0';
            for (int cur : arr) {
                for (int next : edges[cur]) {
                    if (v[next]) continue;
                    char charOfNext = getChar(next);
                    if (max > charOfNext) continue;
                    if (validNodes == null || max < getChar(next)) {
                        validNodes = new ArrayList();
                        max = getChar(next);
                    }
                    validNodes.add(next);
                }
            }
            if (validNodes == null) break;

            sb.append(max);
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int next : validNodes) {
                v[next] = true;
                tmp.add(next);
            }
            arr = tmp;
        }
        return sb;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine();
        edges = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) edges[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }
        System.out.println(getAnswer());
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
