import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int i1 = o1 < 0 ? -o1 : o1;
                int i2 = o2 < 0 ? -o2 : o2;
                if (i1 != i2)   return i1 - i2;
                if (i1 == -o1)  return -1;
                if (i2 == -o2)  return 1;
                return 1;
            }
        });
        while (n-->0) {
            int i = Integer.parseInt(br.readLine());
            if (i != 0) { pq.add(i); continue; }
            sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
        }
        System.out.println(sb);
    }
}
