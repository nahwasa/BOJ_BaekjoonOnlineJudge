import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] res = new int[7];
        res[0]=-1; res[1]=res[2]=3; res[3]=res[4]=2; res[5]=res[6]=1;
        int n = 6, cnt = 0;
        while (n-->0)   cnt += br.readLine().charAt(0) == 'W' ? 1 : 0;
        System.out.println(res[cnt]);
    }
}
