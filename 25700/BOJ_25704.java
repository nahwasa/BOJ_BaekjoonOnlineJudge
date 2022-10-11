import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        int min = p;
        for (int i = 1; i <= 4; i++) {
            if (i*5>n) break;
            switch (i) {
                case 1 : min = Math.min(min, p-500); break;
                case 2 : min = Math.min(min, (int)(p*0.9)); break;
                case 3 : min = Math.min(min, p-2000); break;
                case 4 : min = Math.min(min, (int)(p*0.75)); break;
            }
        }
        System.out.println(min<0?0:min);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
