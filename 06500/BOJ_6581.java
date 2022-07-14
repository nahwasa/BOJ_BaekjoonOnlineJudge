import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    int idx = 0;
    StringBuilder sb = new StringBuilder();
    private void br() {
        sb.append('\n');
        idx = 0;
    }
    private void hr() {
        if (idx != 0) br();
        for (int i = 0; i < 80; i++) sb.append('-');
        sb.append('\n');
        idx = 0;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        ArrayList<String> arr = new ArrayList<>();
        while ((s = br.readLine())!=null) {
            StringTokenizer st = new StringTokenizer(s, " \t\n");
            while (st.hasMoreTokens())
                arr.add(st.nextToken());
        }
        for (String cur : arr) {
            if (cur.equals("<br>")) {
                br();
                continue;
            }
            if (cur.equals("<hr>")) {
                hr();
                continue;
            }
            if (idx+cur.length()+(idx==0?0:1)>80) {
                idx = 0;
                br();
            }
            if (idx != 0) sb.append(' ');
            sb.append(cur);
            idx+=cur.length()+(idx==0?0:1);
        }
        br();
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
