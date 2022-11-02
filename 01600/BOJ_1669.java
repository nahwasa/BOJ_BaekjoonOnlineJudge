import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        if (x==y) {
            System.out.println(0);
            return;
        }
        for (long base = 1, gap = y-x; ; base++) {
            long sum = base*base+base;
            if (sum < gap) continue;
            System.out.println(base*2+(sum-base>=gap?-1:0));
            return;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
