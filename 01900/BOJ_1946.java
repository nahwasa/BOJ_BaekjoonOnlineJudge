import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(tc-->0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            while (n-->0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken());
            }
            int min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    n++;
                }
            }
            sb.append(n+2).append("\n");
        }
        System.out.println(sb);
    }
}
