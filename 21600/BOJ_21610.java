import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    public static void main(String[] args) throws Exception {new Main().solution();}

    static final int[] DR = {0, -1, -1, -1, 0, 1, 1, 1};
    static final int[] DC = {-1, -1, 0, 1, 1, 1, 0, -1};
    int n;
    int[] arr;
    List<Integer> candidates;

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n*n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i*n+j] = Integer.parseInt(st.nextToken());
            }
        }

        candidates = new ArrayList<>();
        for (int i = 1; i <= 2; i++)
            for (int j = 0; j <= 1; j++)
                candidates.add((n-i)*n+j);

        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            proc(d-1, s);
        }

        System.out.println(Arrays.stream(arr).sum());
    }

    private void proc(int d, int s) {
        LinkedHashSet<Integer> tmp = new LinkedHashSet<>();
        for (int cur : candidates) {
            // step 1
            int r = (cur/n + DR[d]*s + n*s)%n;
            int c = (cur%n + DC[d]*s + n*s)%n;

            // step 2
            arr[r*n+c]++;
            tmp.add(r*n+c);
        }

        // step 3 : do nothing

        for (int cur : tmp) {
            int r = cur/n;
            int c = cur%n;

            // step 4
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i==0||j==0) continue;

                    int nr = r+i;
                    int nc = c+j;
                    if (nr<0||nr>=n||nc<0||nc>=n) continue;

                    arr[r*n+c] += arr[nr*n+nc]>0?1:0;
                }
            }
        }

        // step 5
        List<Integer> nextCandidates = new ArrayList<>();
        for (int i = 0; i < n*n; i++) {
            if (tmp.contains(i) || arr[i]<2) continue;

            arr[i]-=2;
            nextCandidates.add(i);
        }

        candidates = nextCandidates;
    }
}
