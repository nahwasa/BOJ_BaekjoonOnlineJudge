import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        int t = Integer.parseInt(br.readLine());
        while (t-->0) main.solution();
        System.out.print(sb);
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        double a =  Double.parseDouble(st.nextToken());
        double ans = 0;
        String unit = "";
        switch (st.nextToken()) {
            case "kg": ans = a*2.2046; unit = " lb"; break;
            case "lb": ans = a*0.4536; unit = " kg"; break;
            case "l": ans = a*0.2642; unit = " g"; break;
            case "g": ans = a*3.7854; unit = " l"; break;
        }
        sb.append(String.format("%.4f%s\n", ans, unit));
    }
}
