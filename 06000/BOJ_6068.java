import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Work {
    int t, s;
    public Work(int t, int s) {
        this.t = t;
        this.s = s;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Work> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list, new Comparator<Work>() {
            @Override
            public int compare(Work o1, Work o2) {
                return o2.s - o1.s;
            }
        });

        int last = list.getFirst().s;
        for (Work w : list) {
            last = Math.min(last, w.s) - w.t;
        }
        System.out.println(last < 0 ? -1 : last);
    }
}
