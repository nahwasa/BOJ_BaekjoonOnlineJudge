import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(st.nextToken().charAt(0)));
        Set<String> hs = new HashSet<>(Arrays.asList("i", "pa", "te", "ni", "niti", "a", "ali", "nego", "no", "ili"));

        while (st.hasMoreTokens()) {
            String cur = st.nextToken();
            if (hs.contains(cur)) continue;
            sb.append(Character.toUpperCase(cur.charAt(0)));
        }

        System.out.println(sb);
    }
}
