import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

interface Tags { public static final double X_DIVIDE_GAP = 0.00005d;}

class Vase {
    private double a, b, h, interval;
    private int numOfInterval;

    public Vase(StringTokenizer st) {
        this.a = Double.parseDouble(st.nextToken());
        this.b = Double.parseDouble(st.nextToken());
        this.h = Double.parseDouble(st.nextToken());
        this.numOfInterval = (int) Math.ceil(h/Tags.X_DIVIDE_GAP);
        this.interval = h/numOfInterval;
    }

    private double f(double x) {
        return a*Math.exp(-(x*x))+b*Math.sqrt(x);
    }

    private double g(double x) {
        double fx = f(x);
        return fx*fx*Math.PI;
    }

    public double getVolume() {
        double ans = 0.0d;
        for (int i = 0; i < numOfInterval; i++) {
            double a = interval*i;
            double b = interval*(i+1);
            ans += interval/6*(g(a)+4*g((a+b)/2)+g(b));
        }
        return ans;
    }
}

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double v = Double.parseDouble(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        double minGap = Double.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Vase vase = new Vase(st);
            double gap = Math.abs(vase.getVolume() - v);
            if (gap < minGap) {
                minGap = gap;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
