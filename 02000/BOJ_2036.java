import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();
        int zeroCnt = 0;

        while (n-->0) {
            Integer cur = Integer.parseInt(br.readLine());
            if (cur == 0) zeroCnt++;
            else if (cur < 0) negative.add(-cur);
            else positive.add(cur);
        }

        Collections.sort(negative, Collections.reverseOrder());
        Collections.sort(positive, Collections.reverseOrder());

        long sum = 0;
        for (int i = 1; i < negative.size(); i+=2) {
            sum += 1l * negative.get(i) * negative.get(i-1);
        }
        if (negative.size()%2 == 1 && zeroCnt == 0) sum -= negative.get(negative.size()-1);

        for (int i = 1; i < positive.size(); i+=2) {
            int a = positive.get(i);
            int b = positive.get(i-1);
            sum += Math.max(a+b, 1l*a*b);
        }
        if (positive.size()%2 == 1) sum += positive.get(positive.size()-1);

        System.out.println(sum);
    }
}
