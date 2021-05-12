import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String num = br.readLine();
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int cur = num.charAt(i) - '0';
            while (k > 0 && !dq.isEmpty()) {
                int tmp = dq.peekLast();
                if (tmp >= cur) break;
                dq.pollLast();
                k--;
            }
            dq.addLast(cur);
        }
        StringBuilder sb = new StringBuilder();
        int cnt = dq.size()-k;
        while (cnt-->0) sb.append(dq.pollFirst());
        System.out.println(sb);
    }
}
