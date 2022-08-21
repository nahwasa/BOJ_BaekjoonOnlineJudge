import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = 0;
        for (int i = 1; i <= 100; i++) {
            int pow = i*i;
            if (pow<m || pow>n) continue;
            if (min == 0) min = pow;
            sum += pow;
        }
        System.out.println(min==0?-1:String.format("%d\n%d", sum, min));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
