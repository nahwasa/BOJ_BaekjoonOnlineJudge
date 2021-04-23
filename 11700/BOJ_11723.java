import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> hs = new HashSet<>();
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "add" : hs.add(Integer.parseInt(st.nextToken())); break;
                case "remove" : hs.remove(Integer.parseInt(st.nextToken())); break;
                case "check" : sb.append(hs.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append('\n'); break;
                case "toggle" :
                    int tmp = Integer.parseInt(st.nextToken());
                    if (hs.contains(tmp))   hs.remove(tmp);
                    else    hs.add(tmp);
                    break;
                case "empty" : hs = new HashSet<>(); break;
                case "all" :
                    hs = new HashSet<>();
                    for (int i = 1; i <= 20; i++)   hs.add(i);
                    break;
            }
        }
        System.out.println(sb);
    }
}
