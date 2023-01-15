import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[4];
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            int nameToIdx = 0;
            switch (name) {
                case "STRAWBERRY": nameToIdx = 0; break;
                case "BANANA": nameToIdx = 1; break;
                case "LIME": nameToIdx = 2; break;
                case "PLUM": nameToIdx = 3; break;
            }
            cnt[nameToIdx]+=num;
        }
        for (int i = 0; i < 4; i++)
            if (cnt[i] == 5) {
                System.out.println("YES");
                return;
            }
        System.out.println("NO");
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
