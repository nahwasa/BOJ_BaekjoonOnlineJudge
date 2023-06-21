import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        switch (br.readLine().charAt(0)) {
            case 'S': System.out.println("HIGHSCHOOL"); return;
            case 'C': System.out.println("MASTER"); return;
            case '2': System.out.println("0611"); return;
            case 'A': System.out.println("CONTEST"); return;

        }
    }
}
