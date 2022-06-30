import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private int getAnswer(String a, String b) {
        StringTokenizer st = new StringTokenizer(a, ":, ");
        HashMap<String, Integer> hm = new HashMap<>();
        while (st.hasMoreTokens()) {
            hm.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(b, "| ");
        int min = Integer.MAX_VALUE;
        while (st.hasMoreTokens()) {
            StringTokenizer tmp = new StringTokenizer(st.nextToken(), "& ");
            int max = -1;
            while (tmp.hasMoreTokens()) {
                max = Math.max(max, hm.get(tmp.nextToken()));
            }
            min = Math.min(max, min);
        }
        return min;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) sb.append(getAnswer(br.readLine(), br.readLine())).append('\n');
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
