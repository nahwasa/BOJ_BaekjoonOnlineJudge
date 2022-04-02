import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        String[] arr = new String[m];
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int[] tmp = new int[n];
            for (int j = 0; j < n; j++)
                tmp[j] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    if (tmp[k]>tmp[j]) sb.append('+');
                    else if (tmp[k]<tmp[j]) sb.append('-');
                    else sb.append('=');
                }
            }
            arr[i] = sb.toString();
        }

        int cnt = 0;
        for (int i = 0; i < m-1; i++) {
            for (int j = i+1; j < m; j++) {
                if (arr[i].equals(arr[j])) cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
