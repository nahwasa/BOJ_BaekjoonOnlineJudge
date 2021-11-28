import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[5];
        for (int i = 1; i <= 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = arr[4];
        cnt += arr[2]/2;
        arr[2] %= 2;
        if (arr[2] == 1) {
            cnt += 1;
            arr[1]-=2;
        }
        cnt += arr[3];
        arr[1] -= arr[3];
        if (arr[1] > 0) {
            cnt+=arr[1]/4;
            cnt+=arr[1]%4==0?0:1;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
