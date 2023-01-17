import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int w = Integer.parseInt(br.readLine());
        int l = Integer.parseInt(br.readLine());
        int h = Integer.parseInt(br.readLine());

        int a = w<l?w:l;
        int b = w<l?l:w;
        System.out.println(a*2>=b&&a>=h*2 ? "good" : "bad");
    }
}
