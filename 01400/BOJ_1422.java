import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        String[] arr = new String[k];
        int maxLen = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = br.readLine();
            maxLen = Math.max(maxLen, arr[i].length());
        }

        Arrays.sort(arr, (s1, s2) -> (s2+s1).compareTo(s1+s2));

        StringBuilder sb = new StringBuilder();
        boolean maxChk = false;
        for (int i = 0; i < k; i++) {
            if (!maxChk && arr[i].length()==maxLen) {
                maxChk = true;
                for (int j = 0; j < n-k+1; j++)
                    sb.append(arr[i]);
            } else {
                sb.append(arr[i]);
            }
        }
        System.out.println(sb);
    }
}
