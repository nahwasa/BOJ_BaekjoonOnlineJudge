import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<17);
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        int a = 0;
        int b = 1;
        int sumA = arr[0];
        int sumB = sum-arr[0];
        int answer = 0;
        while (a<n) {
            answer = Math.max(answer, Math.min(sumA, sumB));
            if (sumA >= sumB) {
                sumA-=arr[a];
                sumB+=arr[a];
                a++;
                continue;
            }
            sumA+=arr[b];
            sumB-=arr[b];
            b++;
            b%=n;
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
