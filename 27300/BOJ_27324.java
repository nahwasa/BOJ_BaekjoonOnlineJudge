import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
    
    public void solution() throws Exception {
        String s = br.readLine();
        System.out.println(s.charAt(0) == s.charAt(1) ? 1 : 0);
    }
}
