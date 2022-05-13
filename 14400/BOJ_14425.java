import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> hs = new HashSet<>();
        while (n-->0) hs.add(br.readLine());
        int cnt = 0;
        while (m-->0) if (hs.contains(br.readLine())) cnt++;
        System.out.println(cnt);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
