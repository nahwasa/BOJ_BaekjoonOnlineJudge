import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    StringBuilder sb = new StringBuilder();
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        while (n-->0) arr[n] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) sb.append(arr[i]).append('\n');
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
