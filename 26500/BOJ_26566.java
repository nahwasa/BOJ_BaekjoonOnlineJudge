import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.PI;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            double res1 = 1d*a1/p1;
            double res2 = (PI*r1*r1)/p2;

            sb.append(res1>res2 ? "Slice of pizza\n" : "Whole pizza\n");
        }

        System.out.print(sb);
    }
}
