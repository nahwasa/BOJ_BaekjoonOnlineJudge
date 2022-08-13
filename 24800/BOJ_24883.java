import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(br.readLine().toLowerCase().charAt(0) == 'n' ? "Naver D2" : "Naver Whale");
    }

  public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
