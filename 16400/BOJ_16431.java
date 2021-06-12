import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] bessie = new int[2];
        bessie[0] = Integer.parseInt(st.nextToken());
        bessie[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] daisy = new int[2];
        daisy[0] = Integer.parseInt(st.nextToken());
        daisy[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] john = new int[2];
        john[0] = Integer.parseInt(st.nextToken());
        john[1] = Integer.parseInt(st.nextToken());

        // calc bessie
        int a = Math.abs(bessie[0] - john[0]);
        int b = Math.abs(bessie[1] - john[1]);
        int resBessie = Math.max(a, b);

        // calc daisy
        a = Math.abs(daisy[0] - john[0]);
        b = Math.abs(daisy[1] - john[1]);
        int resDaisy = a + b;

        // print result
        System.out.println(resBessie == resDaisy ? "tie" : (resBessie < resDaisy ? "bessie" : "daisy"));
    }
}
