import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        double c1 = 1d*p1/a;
        double c2 = 1d*p2/(Math.PI*r*r);
        System.out.println(c1<c2 ? "Slice of pizza" : "Whole pizza");
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
