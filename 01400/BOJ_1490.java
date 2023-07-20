import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    long n;

    private void solution() throws Exception {
        n = Long.parseLong(br.readLine());

        Queue<Long> q = new ArrayDeque<>();
        q.add(n);
        while (!q.isEmpty()) {
            long cur = q.poll();
            if (isPossible(cur)) {
                System.out.println(cur);
                return;
            }

            for (int i = 0; i <= 9; i++) q.add(cur*10+i);
        }
    }

    private boolean isPossible(long cur) {
        long base = n;
        while (base != 0) {
            if (base%10 != 0 && cur%(base%10) != 0) return false;
            base/=10;
        }
        return true;
    }
}
