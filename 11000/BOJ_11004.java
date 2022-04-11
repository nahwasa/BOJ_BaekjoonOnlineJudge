import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        while (n-->0) arr[n] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        System.out.println(arr[k-1]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
