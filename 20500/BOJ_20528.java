import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        char c = st.nextToken().charAt(0);
        while (st.hasMoreTokens()) {
            if (st.nextToken().charAt(0) != c) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
