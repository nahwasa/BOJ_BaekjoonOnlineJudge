import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        IceCream[] arr = new IceCream[n];
        Map<Integer, Integer> cnt = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = new IceCream(a, i+1);
            cnt.put(a, cnt.getOrDefault(a, 0) + 1);
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        int s = 0;
        boolean isReverse = false;
        while (m!=0) {
            int pts = s;
            int pte = pts + cnt.get(arr[pts].a) - 1;
            s = pte+1;
            boolean isMultiplesOf7 = arr[pts].a%7 == 0;

            while (pts<=pte && m!=0) {
                m--;
                sb.append(!isReverse ? arr[pts++].idx : arr[pte--].idx).append('\n');
                if (isMultiplesOf7) isReverse = !isReverse;
            }
        }

        System.out.print(sb);
    }
}

class IceCream implements Comparable<IceCream> {
    int a, idx;

    public IceCream(final int a, final int idx) {
        this.a = a;
        this.idx = idx;
    }

    @Override
    public int compareTo(final IceCream o) {
        if (this.a == o.a)
            return this.idx - o.idx;
        return o.a - this.a;
    }
}
