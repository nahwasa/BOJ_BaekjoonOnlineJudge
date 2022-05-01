import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    String[] arr;

    private void init() {
        arr = new String[16];
        for (int i = 1; i <= 15; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 3; j >= 0; j--) {
                tmp.append((i&1<<j)!=0 ? "딸기":"V");
            }
            arr[i] = tmp.toString();
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            int n = Integer.parseInt(br.readLine()) - 1;
            n%=28;
            n++;
            if (n<=15) {
                sb.append(arr[n]).append('\n');
            } else {
                sb.append(arr[30-n]).append('\n');
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
