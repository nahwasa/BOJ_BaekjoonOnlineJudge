import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) arr[i] = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (true) {
            boolean chk = false;
            for (int i = 1; i < 5; i++) {
                if (arr[i-1] > arr[i]) {
                    int tmp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = tmp;
                    chk = true;
                    for (int j = 0; j < 5; j++) sb.append(arr[j]).append(' ');
                    sb.append('\n');
                }
            }
            if (!chk) break;
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
