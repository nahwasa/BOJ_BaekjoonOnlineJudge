import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] max = new int[3];
        int[] min = new int[3];
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] cur = new int[3];
            for (int i = 0; i < 3; i++) cur[i] = Integer.parseInt(st.nextToken());
            //max
            int tmp1 = Math.max(max[0], max[1]);
            int tmp2 = Math.max(max[1], max[2]);
            max[0] = tmp1 + cur[0];
            max[2] = tmp2 + cur[2];
            max[1] = Math.max(tmp1, tmp2) + cur[1];
            //min
            tmp1 = Math.min(min[0], min[1]);
            tmp2 = Math.min(min[1], min[2]);
            min[0] = tmp1 + cur[0];
            min[2] = tmp2 + cur[2];
            min[1] = Math.min(tmp1, tmp2) + cur[1];
        }
        for (int i = 1; i < 3; i++) {
            max[i] = Math.max(max[i], max[i-1]);
            min[i] = Math.min(min[i], min[i-1]);
        }
        System.out.println(String.format("%s %s", max[2], min[2]));
    }
}
