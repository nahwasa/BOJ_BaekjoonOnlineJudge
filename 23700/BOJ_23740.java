import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        List<Route> routes = new ArrayList<>();
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            routes.add(new Route(s, e, c));
        }

        Collections.sort(routes, (r1, r2) -> r1.s==r2.s ? r2.e-r1.e : r1.s-r2.s);

        List<Route> reorganizationRoutes = new ArrayList<>();
        Route routeTmp = new Route(-1 ,-1, Integer.MAX_VALUE);
        for (Route route : routes) {
            if (routeTmp.e < route.s) {
                reorganizationRoutes.add(routeTmp);
                routeTmp = route;
                continue;
            }

            routeTmp.e = max(routeTmp.e, route.e);
            routeTmp.c = min(routeTmp.c, route.c);
        }
        reorganizationRoutes.add(routeTmp);

        StringBuilder sb = new StringBuilder();
        sb.append(reorganizationRoutes.size()-1).append('\n');
        for (int i = 1; i < reorganizationRoutes.size(); i++) {
            sb.append(reorganizationRoutes.get(i).toString());
        }

        System.out.print(sb);
    }
}

class Route {
    int s, e, c;

    public Route(int s, int e, int c) {
        this.s = s;
        this.e = e;
        this.c = c;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(s).append(' ').append(e).append(' ').append(c).append('\n');
        return sb.toString();
    }
}
