import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<double[]> arr = new ArrayList<>();
            while (n-->0) {
                arr.add(new double[]{Double.parseDouble(st.nextToken()), 1.0});
            }

            while (arr.size() > 1) {
                List<double[]> tmp = new ArrayList<>();

                for (int i = 1; i < arr.size(); i++) {
                    tmp.add(calc(arr.get(i-1), arr.get(i)));
                }
                arr = tmp;
            }

            sb.append(String.format("%.4f %.4f\n", arr.get(0)[0], arr.get(0)[1]));
        }
        System.out.print(sb);
    }

    public double[] calc(double[] p1, double[] p2) {
        double x1 = p1[0]>p2[0]?p2[0]:p1[0];
        double y1 = p1[0]>p2[0]?p2[1]:p1[1];
        double x2 = p1[0]>p2[0]?p1[0]:p2[0];
        double y2 = p1[0]>p2[0]?p1[1]:p2[1];

        double dist = sqrt(sq(x2 - x1)+sq(y2 - y1));

        double xc = (x1 + x2)/2;
        double yc = (y1 + y2)/2;
        double height = sqrt(4 - sq(dist/2));

        double rx = -(y2 - y1)/dist*height;
        double ry = (x2 - x1)/dist*height;

        return new double[] {xc+rx, yc+ry};
    }

    private double sq(double x) {return x*x;}
}
