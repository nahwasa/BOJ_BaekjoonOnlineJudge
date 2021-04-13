import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res1 = n * 78 / 100;
        int res2 = (n*8/10) + (n*2/10*78/100);
        System.out.println(String.format("%d %d", res1, res2));
    }
}
