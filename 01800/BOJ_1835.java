import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    class Card { int ans = -1; }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Card> dq = new ArrayDeque<>();
        Card[] arr = new Card[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Card();
            dq.addLast(arr[i]);
        }
        for (int i = 1; i < n; i++) {
            int cnt = i%dq.size();
            while (cnt-->0) {
                dq.addLast(dq.pollFirst());
            }
            dq.pollFirst().ans = i;
        }
        dq.pollFirst().ans = n;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(arr[i].ans).append(' ');
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
