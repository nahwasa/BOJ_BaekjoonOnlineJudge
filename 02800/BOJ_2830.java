import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] bitCnt = new int[(int)(Math.log(1000000.0) / Math.log(2.0)) + 1][2];
        while(n-->0) {
            int cur = Integer.parseInt(br.readLine());
            int comp = 1;
            int cnt = 0;
            while (comp <= cur) {
                bitCnt[cnt][(cur & comp) != 0 ? 1 : 0]++;
                comp <<= 1;
                cnt++;
            }
            for (int i = cnt; i < bitCnt.length; i++) bitCnt[i][0]++;
        }
        long mult = 1;
        long sum = 0;
        for (int i = 0; i < bitCnt.length; i++, mult<<=1) {
            sum += mult * bitCnt[i][0] * bitCnt[i][1];
        }
        System.out.println(sum);
    }
}
