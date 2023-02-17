import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> candidates = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        while (n-->0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (t==1) p = 0;
            candidates.add(e==1 ? new int[]{d/2+d%2,p/2} : new int[]{d,p});
        }
        st = new StringTokenizer(br.readLine());
        int hd = Integer.parseInt(st.nextToken());
        int hp = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long wa = 0;
        while (m-->0) {
            while (!candidates.isEmpty() && candidates.peek()[0] <= hd) pq.add(candidates.poll()[1]);
            
            if (pq.isEmpty()) {System.out.println(-1); return;}
            int p = pq.poll();
            if (p>hp) wa += p-hp;
            hd+=1; hp+=1;
        }
        System.out.println(wa);
    }
}
