import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        int sum = 0, base = 1;
        for (int i = n.length()-1; i >= 0; i--, base*=b)
            sum += base * (n.charAt(i)>='A' ? 10+n.charAt(i)-'A' : n.charAt(i)-'0');
        System.out.println(sum);
    }
}
