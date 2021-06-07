import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int tc = 1; tc <= n; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            char op = st.nextToken().charAt(0);
            int b = Integer.parseInt(st.nextToken());
            st.nextToken();
            int res = Integer.parseInt(st.nextToken());

            boolean isValid = false;
            if (op == '-' && a-b==res)  isValid = true;
            if (op == '+' && a+b==res)  isValid = true;

            result.append(String.format("Case %d: %s\n", tc, isValid?"YES":"NO"));
        }
        System.out.println(result);
    }
}
