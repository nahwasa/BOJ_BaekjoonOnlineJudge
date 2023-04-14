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
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int big = Math.max(l, r);
        if (l==0 && r==0) {
            System.out.println("Not a moose");
            return;
        }
        if (l == r) {
            System.out.print("Even ");
        } else {
            System.out.print("Odd ");
        }
        System.out.println(big*2);
    }
}
