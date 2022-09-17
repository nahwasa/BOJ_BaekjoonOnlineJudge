import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Viewer {
    boolean isDogLover;
    int c, d;
    ArrayList<Integer> edge;
    public Viewer(String str) {
        edge = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(str, " CD");
        isDogLover = str.charAt(0) == 'D';
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        c = isDogLover?b:a;
        d = isDogLover?a:b;
    }
}

public class Main {
    int[] matched;
    boolean[] visit;
    ArrayList<Viewer> left, right;

    private boolean matching(int cat) {
        Viewer tmp = left.get(cat);
        for (int dog : tmp.edge) {
            if (visit[dog]) continue;
            visit[dog] = true;
            if (matched[dog] == -1 || matching(matched[dog])) {
                matched[dog] = cat;
                return true;
            }
        }
        return false;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            left = new ArrayList<>(c+1);
            right = new ArrayList<>(d+1);
            for (int i = 0; i < v; i++) {
                Viewer tmp = new Viewer(br.readLine());
                if (tmp.isDogLover) right.add(tmp);
                else left.add(tmp);
            }
            for (int i = 0; i < left.size(); i++) {
                Viewer a = left.get(i);
                for (int j = 0; j < right.size(); j++) {
                    Viewer b = right.get(j);
                    if (a.d == b.d || a.c == b.c) {
                        a.edge.add(j);
                        b.edge.add(i);
                    }
                }
            }

            matched = new int[right.size()];
            Arrays.fill(matched, -1);
            visit = new boolean[right.size()];
            int cnt = 0;
            for (int i = 0; i < left.size(); i++) {
                if (matching(i)) {
                    cnt++;
                    visit = new boolean[right.size()];
                }
            }
            sb.append(v-cnt).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
