import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) - 1;
        long x = 1;
        long y = 1;
        while (n-->0) {
            long tmp = x + y;
            x = y;
            y = tmp;
        }
        System.out.println(x*2 + y*2);
    }
}
