import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a; i++) {
            sb.append((char)('A'+i%26));
        }
        for (int i = 0; i < b; i++) {
            sb.append((char)('a'+i%26));
        }
        for (int i = 0; i < n-a-b; i++) {
            sb.append(i%10);
        }

        System.out.println(sb);
    }
}
