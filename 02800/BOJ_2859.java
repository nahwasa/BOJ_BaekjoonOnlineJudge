import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    private static final int LIMIT = 1440;
    private static final String[] DAYS = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        int s1 = getMin(br.readLine());
        int s2 = getMin(br.readLine());
        int f1 = getMin(br.readLine());
        int f2 = getMin(br.readLine());

        for (int i = 0; i < LIMIT; i++) {
            int cur = s1 + f1*i;
            if (cur-s2<0 || (cur-s2)%f2 != 0) continue;

            int min = cur%60;
            cur/=60;
            int hour = cur%24;
            cur/=24;

            System.out.println(DAYS[cur%7]);
            System.out.println(lpad(hour) + ":" + lpad(min));
            return;
        }
        System.out.println("Never");
    }

    private String lpad(int num) {
        if (num < 10)
            return "0"+num;
        return String.valueOf(num);
    }

    private int getMin(String hhmm) {
        String[] split = hhmm.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
