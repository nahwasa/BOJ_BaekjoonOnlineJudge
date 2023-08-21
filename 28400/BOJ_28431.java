import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int[] arr = new int[10];
        for (int i = 0; i < 5; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 0; i < 10; i++) {
            if (arr[i]%2!=0) System.out.println(i);
        }
    }
}
