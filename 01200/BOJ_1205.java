import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if (n == 0) {
            System.out.println(1);
            return;
        }

        st = new StringTokenizer(br.readLine());
        int rank = -1;
        int bf = -1;
        int bfIdx = -1;
        for (int i = 1; rank == -1 && i <= n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur < score) {
                rank = bf == score ? bfIdx : i;
            }
            if (bf != cur) {
                bf = cur;
                bfIdx = i;
            }

        }

        if (rank == -1 && n+1 <= p)
            rank = score == bf ? bfIdx : n+1;

        System.out.println(rank <= p ? rank : -1);
    }
}
