import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int we = 0;
        int sn = 0;

        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'W': we++; break;
                case 'E': we--; break;
                case 'S': sn++; break;
                case 'N': sn--; break;
            }
        }

        System.out.println(Math.abs(we) + Math.abs(sn));
    }
}
