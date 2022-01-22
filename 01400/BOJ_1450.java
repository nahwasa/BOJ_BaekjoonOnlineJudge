import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    private int n;
    private int c, answer = 0;
    private int[] arr = new int[30];
    private TreeMap<Integer, Integer> hm = new TreeMap<>();

    private void search(int idx, int sum) {
        if (sum > c) return;
        if (idx == 30 || arr[idx] == 0) {
            answer += hm.getOrDefault(hm.floorKey(c-sum), 0);
            return;
        }
        search(idx+1, sum);
        search(idx+1, sum+arr[idx]);
    }

    private void prefixSum() {
        Integer tmp = hm.firstKey();
        int sumTmp = 0;

        while (true) {
            sumTmp += hm.get(tmp);
            hm.put(tmp, sumTmp);

            tmp = hm.higherKey(tmp);
            if (tmp == null) break;
        }
    }

    private void initLeft(int idx, int sum) {
        if (sum > c) return;
        if (idx == 15 || arr[idx] == 0) {
            hm.put(sum, hm.getOrDefault(sum, 0)+1);
            return;
        }
        initLeft(idx+1, sum);
        initLeft(idx+1, sum+arr[idx]);
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        initLeft(0, 0);
        prefixSum();
        search(15, 0);

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
