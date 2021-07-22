import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[d+1];
        arr[0] = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= d; i++) arr[i] = Math.min(arr[i-1], Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        while (n-->0 && d!=-1) {
            int cur = Integer.parseInt(st.nextToken());
            for (; d >= 0; d--) if (arr[d] >= cur) break;
            d--;
        }
        System.out.println(d + 1);
    }
}
