import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        switch (br.readLine().charAt(0)) {
            case 'M': System.out.println("MatKor"); break;
            case 'W': System.out.println("WiCys"); break;
            case 'C': System.out.println("CyKor"); break;
            case 'A': System.out.println("AlKor"); break;
            case '$': System.out.println("$clear"); break;
        }
    }
}
