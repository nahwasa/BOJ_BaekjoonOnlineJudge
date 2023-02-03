import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        String[] tmp = new String[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = br.readLine();
        }

        String str = br.readLine();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(tmp[i]);
            String to = st.nextToken();
            String from = st.nextToken();
            str = str.replaceAll(from, to);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        System.out.println(str.substring(s-1, e));
    }
}
