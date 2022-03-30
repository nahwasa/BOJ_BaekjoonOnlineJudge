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
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < this.n.length(); i++) sb1.append(this.n.charAt(i));
            for (int i = 0; i < o.n.length(); i++) sb2.append(o.n.charAt(i));
            for (int i = 0; i < this.n.length(); i++) sb2.append(this.n.charAt(i));
            for (int i = 0; i < o.n.length(); i++) sb1.append(o.n.charAt(i));
            String s1 = sb1.toString();
            String s2 = sb2.toString();

            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(i)) continue;
                chk = true;
                return s2.charAt(i) - s1.charAt(i);
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
