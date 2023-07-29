import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        if (a>=3&&b<=4) System.out.println("TroyMartian");
        if (a<=6&&b>=2) System.out.println("VladSaturnian");
        if (a<=2&&b<=3) System.out.println("GraemeMercurian");
        System.out.println();
    }
}
