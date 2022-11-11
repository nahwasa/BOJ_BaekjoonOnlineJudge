import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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

class UnionFind {
    int[] parents;

    public UnionFind(int num) {
        parents = new int[num];
        Arrays.fill(parents, -1);
    }

    public int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        int h = parents[a]<parents[b]?a:b;
        int l = parents[a]<parents[b]?b:a;
        parents[h] += parents[l];
        parents[l] = h;
    }
}

public class Main {
    UnionFind uf;
    private int ni(StringTokenizer st) { return Integer.parseInt(st.nextToken()); }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
        int n = Integer.parseInt(br.readLine());
        uf = new UnionFind(n);
        Line[] lines = new Line[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i] = new Line(ni(st), ni(st), ni(st), ni(st));
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (lines[i].isIntersection(lines[j]))
                    uf.union(i, j);
            }
        }

        int cnt = 0;
        int min = 0;
        for (int i = 0; i < n; i++) {
            if (uf.parents[i] < 0) {
                cnt++;
                if (uf.parents[i] < min)
                    min = uf.parents[i];
            }
        }
        System.out.printf("%d\n%d\n", cnt, -min);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
