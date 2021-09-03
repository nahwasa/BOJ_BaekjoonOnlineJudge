import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int l = h > w ? h : w;
        int s = h > w ? w : h;
        double max = Math.min((double)l / 3, s);
        max = Math.max(max, Math.min((double)l/2, (double)s/2));
        System.out.println(max);
    }
}
