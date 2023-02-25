import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    private static final int LIMIT = 2000000;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int pMax = -LIMIT;
        int pMin = LIMIT;
        int mMax = -LIMIT;
        int mMin = LIMIT;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pMax = max(pMax, x+y);
            pMin = min(pMin, x+y);
            mMax = max(mMax, x-y);
            mMin = min(mMin, x-y);
        }
        System.out.println(max(pMax-pMin, mMax-mMin));
    }
}
