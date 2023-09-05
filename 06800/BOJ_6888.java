import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        y-=x;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= y; i++) {
            if (i%60 == 0) {
                sb.append("All positions change in year ").append(x+i).append('\n');
            }
        }
        System.out.print(sb);
    }
}
