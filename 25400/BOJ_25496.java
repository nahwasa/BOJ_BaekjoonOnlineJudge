import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        while (n-->0) arr[n] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int cnt = 0;
        int i = 0;
        while (p<200 && i<arr.length) {
            cnt++;
            p+=arr[i++];
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
