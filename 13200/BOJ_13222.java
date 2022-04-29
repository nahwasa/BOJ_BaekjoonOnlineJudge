import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int len = w*w+h*h;
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            int cur = Integer.parseInt(br.readLine());
            if (cur*cur<=len) sb.append('Y').append('E').append('S').append('\n');
            else sb.append('N').append('O').append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
