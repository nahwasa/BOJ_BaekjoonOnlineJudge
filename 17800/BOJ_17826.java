import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[50];
        for (int i = 0; i < 50; i++) arr[i] = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int i = 0;
        for (; i < 50; i++) {
            if (arr[i] <= n) break;
        }
        i++;
        if (i<=5) System.out.println("A+");
        else if (i<=15) System.out.println("A0");
        else if (i<=30) System.out.println("B+");
        else if (i<=35) System.out.println("B0");
        else if (i<=45) System.out.println("C+");
        else if (i<=48) System.out.println("C0");
        else System.out.println("F");

    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
