import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

import static java.lang.Math.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) min = min(min, arr[i] = Integer.parseInt(br.readLine()));
        int s = 0;
        while (arr[s] == min) s++;
        int gcd = arr[s]-min;
        for (int i = ++s; i < n; i++) gcd = gcd(gcd, arr[i]-min);

        TreeSet<Integer> res = new TreeSet<>();
        res.add(gcd);
        int limit = (int) ceil(sqrt(gcd));
        for (int i = 2; i <= limit; i++) {
            if (gcd%i!=0) continue;

            res.add(i);
            res.add(gcd/i);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer cur : res) sb.append(cur).append(' ');
        System.out.println(sb);
    }

    private int gcd(int a, int b) {
        if (b==0) return a;
        
        int r = -1;
        while (r!=0) {
            r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}
