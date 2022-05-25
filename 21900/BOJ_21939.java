import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    class Problem {
        int p, l;
        boolean isRecommendedProblem;
        public Problem(int p, int l) {
            this(p, l, true);
        }
        public Problem(int p, int l, boolean isRecommendedProblem) {
            this.p = p;
            this.l = l;
            this.isRecommendedProblem = isRecommendedProblem;
        }
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Problem> maxHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1.l == o2.l)
                return o2.p - o1.p;
            return o2.l - o1.l;
        });
        PriorityQueue<Problem> minHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1.l == o2.l)
                return o1.p - o2.p;
            return o1.l - o2.l;
        });
        HashSet<Integer> solvedProblems = new HashSet<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(n-->0) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Problem problem = new Problem(p, l);
            maxHeap.add(problem);
            minHeap.add(problem);
        }
        int m = Integer.parseInt(br.readLine());
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "add" :
                    int p = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());
                    Problem problem = new Problem(p, l, false);
                    maxHeap.add(problem);
                    minHeap.add(problem);
                    break;
                case "recommend" :
                    int q = Integer.parseInt(st.nextToken());
                    PriorityQueue<Problem> tmp = q==1?maxHeap:minHeap;
                    while (tmp.peek().isRecommendedProblem && solvedProblems.contains(tmp.peek().p)) {
                        tmp.poll();
                    }
                    sb.append(tmp.peek().p).append('\n');
                    break;
                case "solved" :
                    solvedProblems.add(Integer.parseInt(st.nextToken()));
                    break;
            }
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
