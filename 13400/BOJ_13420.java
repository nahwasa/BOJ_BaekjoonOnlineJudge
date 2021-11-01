import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            char op = st.nextToken().charAt(0);
            long b = Long.parseLong(st.nextToken());
            st.nextToken();
            long ans = Long.parseLong(st.nextToken());

            long calc = 0;
            switch (op) {
                case '+' : calc = a+b;  break;
                case '-' : calc = a-b;  break;
                case '*' : calc = a*b;  break;
                case '/' : calc = a/b;  break;
            }
            sb.append(calc==ans ? "correct" : "wrong answer").append('\n');
        }
        System.out.println(sb);
    }
}
