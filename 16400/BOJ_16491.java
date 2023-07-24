import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    int n;
    int[] answer;
    boolean[] v;
    Line[] lines;
    Point[] robots, shelters;
    boolean isEnd = false;

    private void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        robots = new Point[n+1];
        shelters = new Point[n+1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            robots[i] = new Point(a, b);
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            shelters[i] = new Point(a, b);
        }

        answer = new int[n+1];
        v = new boolean[n+1];
        lines = new Line[n+1];

        bf(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.print(sb);
    }

    private void bf(int idx) {
        if (!isEnd && idx == n+1) {
            isEnd = true;

            return;
        }

        for (int i = 1; !isEnd && i <= n; i++) {
            if (v[i]) continue;

            Line cur = new Line(robots[idx], shelters[i]);
            if (!isValidLine(idx, cur)) continue;

            lines[idx] = cur;
            v[i] = true;
            answer[idx] = i;
            bf(idx+1);
            v[i] = false;
        }
    }

    private boolean isValidLine(int limit, Line cur) {
        for (int i = 1; i < limit; i++) {
            if (cur.isIntersection(lines[i])) return false;
        }
        return true;
    }
}

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
        if (res1==0&&res2==0) {
            return this.a.compareTo(ano.b)<=0 && ano.a.compareTo(this.b)<=0;
        }
        return res1<=0 && res2<=0;
    }
}

class Ccw {
    public static int getCcw(Point a, Point b, Point c) {
        Point[] arr = {a,b,c,a};
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += arr[i].x*arr[i+1].y-arr[i+1].x*arr[i].y;
        }
        return sum>0?1:sum<0?-1:0;
    }
}
