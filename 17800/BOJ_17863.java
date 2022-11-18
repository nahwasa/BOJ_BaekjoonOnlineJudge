import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(br.readLine().indexOf("555")==0?"YES":"NO ");
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
