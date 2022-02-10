import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>();
        while(n-->0) hs.add(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(m-->0) if (hs.contains(br.readLine())) cnt++;
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
