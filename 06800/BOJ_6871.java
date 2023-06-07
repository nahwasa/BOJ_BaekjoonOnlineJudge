import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int cost1 = calc(a,b,c,100,25,15,20);
        int cost2 = calc(a,b,c,250,45,35,25);

        System.out.printf("Plan A costs %.2f\nPlan B costs %.2f\n%s\n", 1d*cost1/100, 1d*cost2/100, msg(cost1, cost2));
    }

    private String msg(final int cost1, final int cost2) {
        if (cost1 == cost2)
            return "Plan A and B are the same price.";

        if (cost1 > cost2)
            return "Plan B is cheapest.";

        return "Plan A is cheapest.";
    }

    private int calc(int a, final int b, final int c, final int free, final int cost1, final int cost2, final int cost3) {
        a = Math.max(a-free, 0);
        return a*cost1 + b*cost2 + c*cost3;
    }
}
