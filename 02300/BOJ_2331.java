import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private int getNext(int next, int p) {
        int sum = 0;
        while (next != 0) {
            int digit = next%10;
            int tmp = digit;
            for (int i = 0; i < p-1; i++)
                tmp *= digit;
            sum += tmp;
            next/=10;
        }
        return sum;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> hm = new HashMap<>();
        int cnt = 0;
        int next = a;
        while (!hm.containsKey(next)) {
            hm.put(next, cnt++);
            next = getNext(next, p);
        }
        System.out.println(hm.get(next));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
