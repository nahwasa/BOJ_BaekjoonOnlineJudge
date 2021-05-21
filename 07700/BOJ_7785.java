import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> hs = new HashSet<>();
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if (st.nextToken().charAt(0) == 'e')    hs.add(name);
            else    hs.remove(name);
        }
        Object[] res = hs.toArray();
        Arrays.sort(res, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (Object s : res)    sb.append(s).append('\n');
        System.out.println(sb);
    }
}
