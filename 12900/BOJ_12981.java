import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int cnt = arr[0];
        arr[1]-=arr[0];
        arr[2]-=arr[0];
        cnt += arr[1]/3 + arr[2]/3;
        cnt += arr[1]%3!=0 ? 1 : 0;
        cnt += arr[2]%3!=0 ? 1 : 0;
        if (arr[1]%3 == 1 && arr[2]%3 == 1)
            cnt--;
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
