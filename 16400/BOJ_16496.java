import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    class Num implements Comparable<Num> {
        String n;
        public Num(String n) {
            this.n = n;
        }

        @Override
        public int compareTo(Num o) {
            for (int i = 0; i < this.n.length()*o.n.length(); i++) {
                char c1 = this.n.charAt(i%this.n.length());
                char c2 = o.n.charAt(i%o.n.length());
                if (c1 == c2) continue;
                chk = true;
                return c2-c1;
            }
            return 0;
        }
    }
    boolean chk = false;
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Num> arr = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-->0) arr.add(new Num(st.nextToken()));
        Collections.sort(arr);
        if (!chk && arr.get(0).n.equals("0")) {
            System.out.println("0");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            String cur = arr.get(i).n;
            for (int j = 0; j < cur.length(); j++) {
                sb.append(cur.charAt(j));
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
