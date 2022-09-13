import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

class Msg implements Comparable<Msg> {
    int num, idx, cnt;
    public Msg (int num, int idx ,int cnt) {
        this.num = num;
        this.idx = idx;
        this.cnt = cnt;
    }
    public void inc() { this.cnt++; }

    @Override
    public int compareTo(Msg o) {
        if (this.cnt == o.cnt)
            return this.idx - o.idx;
        return o.cnt - this.cnt;
    }
}

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        HashMap<Integer, Msg> hm = new HashMap<>();
        ArrayList<Msg> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (!hm.containsKey(cur)) {
                Msg tmp = new Msg(cur, i, 0);
                hm.put(cur, tmp);
                list.add(tmp);
            }
            hm.get(cur).inc();
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Msg tmp = list.get(i);
            int num = tmp.num;
            int cnt = tmp.cnt;
            while (cnt-->0)
                sb.append(num).append(' ');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
