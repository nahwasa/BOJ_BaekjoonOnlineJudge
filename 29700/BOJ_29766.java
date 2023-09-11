import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String str = br.readLine();
        int cnt = 0;
        char[] find = {'D','K','S','H'};
        for (int i = 0; i < str.length()-3; i++) {
            for (int j = 0; j < 4; j++) {
                if (str.charAt(i+j) != find[j])
                    break;
                if (j==3) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
