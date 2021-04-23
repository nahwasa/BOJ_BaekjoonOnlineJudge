import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            pq.add(arr[i]);
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        int idx = 0;
        while (!pq.isEmpty()) {
            int tmp = pq.poll();
            if (!hm.containsKey(tmp))   hm.put(tmp, idx++);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(hm.get(arr[i])).append(' ');
        }
        System.out.println(sb);
    }
}
