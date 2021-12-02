import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        // Ayu
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int cntAyu = 0;
        if (st.nextToken().charAt(0) == 'r') {
            for (int i = s; i <= n; i++) cntAyu += arr[i];
        } else {
            for (int i = s; i >= 1; i--) cntAyu += arr[i];
        }

        // Budi
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        int cntBudi = 0;
        if (st.nextToken().charAt(0) == 'r') {
            for (int i = s; i <= n; i++) cntBudi += arr[i]==0?1:0;
        } else {
            for (int i = s; i >= 1; i--) cntBudi += arr[i]==0?1:0;
        }

        // answer
        System.out.println(cntAyu + " " + cntBudi);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
