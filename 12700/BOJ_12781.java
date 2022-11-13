import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o) {
        if (this.x == o.x)
            return this.y-o.y;
        return this.x-o.x;
    }
}

class Line {
    Point a, b;
    public Line(Point p1, Point p2) {
        a = p1.compareTo(p2)<=0?p1:p2;
        b = p1.compareTo(p2)<=0?p2:p1;
    }
    public Line(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }
    public boolean isIntersection(Line ano) {
        int res1 = Ccw.getCcw(this.a, this.b, ano.a) * Ccw.getCcw(this.a, this.b, ano.b);
        int res2 = Ccw.getCcw(ano.a, ano.b, this.a) * Ccw.getCcw(ano.a, ano.b, this.b);
        return res1<0 && res2<0;
    }
}

class Ccw {
    public static int getCcw(Point a, Point b, Point c) {
        Point[] arr = {a,b,c,a};
        long sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += 1l*arr[i].x*arr[i+1].y-1l*arr[i+1].x*arr[i].y;
        }
        return sum>0?1:sum<0?-1:0;
    }
}

public class Main {
    private int ni(StringTokenizer st) { return Integer.parseInt(st.nextToken()); }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Line line1 = new Line(ni(st), ni(st), ni(st), ni(st));
        Line line2 = new Line(ni(st), ni(st), ni(st), ni(st));
        System.out.println(line1.isIntersection(line2)?1:0);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
