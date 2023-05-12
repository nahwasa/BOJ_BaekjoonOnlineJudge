import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int LIMIT = 1000000001;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }
        points[0] = points[n];

        List<Line> lines = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            lines.add(new Line(points[i-1], points[i]));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Point curPoint = new Point(x, y);

            if (samePointExist(curPoint, points) || curPointIsOnLine(curPoint, lines)) {
                sb.append(1).append('\n');
                continue;
            }

            Line cur = new Line(curPoint, new Point(LIMIT-41, LIMIT));
            int cnt = 0;
            for (Line line : lines) {
                if (Line.isIntersection(cur, line)) cnt++;
            }

            sb.append(cnt&1).append('\n');
        }

        System.out.print(sb);
    }

    private boolean curPointIsOnLine(final Point curPoint, final List<Line> lines) {
        Line cur = new Line(curPoint, curPoint);
        for (Line line : lines) {
            if (Line.isIntersection(cur, line)) {
                return true;
            }
        }

        return false;
    }

    private boolean samePointExist(final Point curPoint, final Point[] points) {
        for (Point point : points) {
            if (curPoint.equals(point)) {
                return true;
            }
        }

        return false;
    }
}

class Point implements Comparable<Point> {
    long x, y;
    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(final Object obj) {
        Point o = (Point) obj;
        return this.x == o.x && this.y == o.y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.equals(o))
            return 0;

        if (this.x == o.x)
            return this.y-o.y < 0 ? -1 : 1;
        return this.x - o.x < 0 ? -1 : 1;
    }
}

class Line {
    Point p1, p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1.compareTo(p2)<=0?p1:p2;
        this.p2 = p1.compareTo(p2)<=0?p2:p1;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    private static int ccw(Point a, Point b, Point c) {
        Point[] arr = {a,b,c,a};
        long sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += 1l*arr[i].x*arr[i+1].y-1l*arr[i+1].x*arr[i].y;
        }
        return sum>0?1:sum<0?-1:0;
    }

    public static boolean isIntersection(Line line1, Line line2) {
        int res1 = ccw(line1.p1, line1.p2, line2.p1);
        int res2 = ccw(line1.p1, line1.p2, line2.p2);

        int res3 = ccw(line2.p1, line2.p2, line1.p1);
        int res4 = ccw(line2.p1, line2.p2, line1.p2);

        if (res1!=res2 && res3!=res4)
            return true;

        if (res1==0 && res2==0 && res3==0 && res4==0)
            return line1.p1.compareTo(line2.p2)<=0 && line2.p1.compareTo(line1.p2)<=0;

        return false;
    }
}
