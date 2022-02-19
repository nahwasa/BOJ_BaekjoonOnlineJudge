import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hm = new HashMap<>();
        while (n-->0) {
            st = new StringTokenizer(br.readLine());
            hm.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        while (a-->0) {
            int sum = 0;
            while (true) {
                String str = br.readLine();
                if (str.equals(".")) break;
                st = new StringTokenizer(str);
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    if (hm.containsKey(token))
                        sum += hm.get(token);
                }

            }
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
