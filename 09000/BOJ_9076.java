import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) sb.append(main.solution()).append('\n');
        System.out.print(sb);
    }

    public String solution() throws Exception {
        int[] arr = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        if (arr[1]+4<=arr[3]) return "KIN";
        return String.valueOf(arr[1]+arr[2]+arr[3]);
    }
}
