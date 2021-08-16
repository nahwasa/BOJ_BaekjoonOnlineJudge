import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int min = a*x + b*y;
        int h = x > y ? x : y;
        int l = x > y ? y : x;
        for (int i = l*2; i <= h*2; i++) {
            int tmp = i/2;
            min = Math.min(min, c*tmp*2 + (x-tmp<0?0:x-tmp)*a + (y-tmp<0?0:y-tmp)*b);
        }

        System.out.println(min);
    }
}
