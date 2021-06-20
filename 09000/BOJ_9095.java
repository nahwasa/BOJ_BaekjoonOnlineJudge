import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[12];
        arr[1] = arr[2] = arr[3] = 1;
        for (int i = 2; i <= 11; i++) for (int j = -1; j >= -3; j--)  if (i+j > 0) arr[i] += arr[i+j];

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) sb.append(arr[Integer.parseInt(br.readLine())]).append('\n');
        System.out.println(sb);
    }
}
