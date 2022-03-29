import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String regex = "^(pi|ka|chu)*$";
        System.out.println(str.matches(regex)?"YES":"NO");
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
