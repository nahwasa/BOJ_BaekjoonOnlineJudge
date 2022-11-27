import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private int getPenalty(int gap) {
        if (gap <= 0)
            return 0;
        if (gap <= 20)
            return 100;
        if (gap <= 30)
            return 270;
        return 500;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int limit = Integer.parseInt(br.readLine());
        int cur = Integer.parseInt(br.readLine());
        int gap = cur - limit;
        if (gap<=0) {
            System.out.println("Congratulations, you are within the speed limit!");
            return;
        }
        System.out.printf("You are speeding and your fine is $%d.", getPenalty(gap));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
