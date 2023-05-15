import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] gap = n%4 == 1 ? new int[]{1, 2, -1, 2} : new int[]{2, -1, 2, 1};
        int base = 0, pt = 0;
        StringBuilder sb = new StringBuilder();
        while (n-->0) { sb.append(base += gap[pt++]).append(' '); pt%=4; }
        System.out.println("YES\n"+sb);
    }
}
