import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int idx = -1;
        int cnt = 0;
        while (idx != 0 && idx <= a.length()) {
            idx = a.indexOf(b, idx);
            if (idx != -1)
                cnt++;
            idx++;
        }
        System.out.println(cnt);
    }
}
