import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static int ni() { return Integer.parseInt(st.nextToken()); }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int w = ni() - 2; int h = ni() - 2;
        System.out.println(w-ni() >= 0 && h-ni() >= 0 ? 1 : 0);
    }
}
