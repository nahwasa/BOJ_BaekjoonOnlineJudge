import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static boolean isComplete(boolean[] chk) {
        for (boolean b : chk)   if (!b) return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {
            int cnt = 1;
            long n = Long.parseLong(s);

            boolean[] chk = new boolean[10];
            while (!isComplete(chk)) {
                long tmp = cnt++ * n;
                while (tmp != 0) {
                    chk[(int) (tmp%10)] = true;
                    tmp /= 10;
                }
            }
            sb.append(cnt-1).append('\n');
        }
        System.out.println(sb);
    }
}
