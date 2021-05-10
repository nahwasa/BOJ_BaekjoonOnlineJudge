import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // input buffer
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int cnt = 1;
        while (b > a) {
            if (b > 10 && b % 10 == 1) {
                cnt++;
                b /= 10;
                continue;
            }
            if (b >= 2 && b % 2 == 0) {
                cnt++;
                b /= 2;
                continue;
            }
            break;
        }
        System.out.println(a==b?cnt:-1);
    }
}
