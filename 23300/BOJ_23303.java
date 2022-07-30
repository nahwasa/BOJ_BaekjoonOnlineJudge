import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(br.readLine().toLowerCase().indexOf("d2")!=-1 ? "D2":"unrated");
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
