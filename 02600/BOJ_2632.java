import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int g = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arrA = new int[a*2+1];
        for (int i = 1; i <= a; i++) arrA[i] = arrA[a+i] = Integer.parseInt(br.readLine());
        int[] arrB = new int[b*2+1];
        for (int i = 1; i <= b; i++) arrB[i] = arrB[b+i] = Integer.parseInt(br.readLine());

        for (int i = 1; i <= a*2; i++) arrA[i] += arrA[i-1];
        for (int i = 1; i <= b*2; i++) arrB[i] += arrB[i-1];

        int answer = 0;

        Map<Integer, Integer> cnt = new HashMap<>();
        if (arrA[a] == g) answer++;
        cnt.put(arrA[a], 1);

        for (int i = 1; i <= a; i++) {
            for (int j = i; j < i+a-1; j++) {
                int rangeSum = arrA[j]-arrA[i-1];
                if (rangeSum == g) answer++;
                if (rangeSum >= g) continue;
                cnt.put(rangeSum, cnt.getOrDefault(rangeSum, 0) + 1);
            }
        }

        if (arrB[b] == g) answer++;
        answer += cnt.getOrDefault(g-arrB[b], 0);

        for (int i = 1; i <= b; i++) {
            for (int j = i; j < i+b-1; j++) {
                int rangeSum = arrB[j]-arrB[i-1];
                if (rangeSum == g) answer++;

                answer += cnt.getOrDefault(g-rangeSum, 0);
            }
        }

        System.out.println(answer);
    }
}
