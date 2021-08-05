import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String winner = st.nextToken();

        HashMap<String, Integer> hm = new HashMap<>();
        String winnerChat = null;
        while (n-->0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String chat = st.nextToken();
            if (!hm.containsKey(chat)) hm.put(chat, 0);
            if (name.equals(winner)) { winnerChat = chat; break; }
            hm.put(chat, hm.get(chat) + 1);
        }
        System.out.println(hm.get(winnerChat));
    }
}
