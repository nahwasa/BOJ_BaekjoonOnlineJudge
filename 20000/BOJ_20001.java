import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int cnt = 0;
        while (true) {
            String s = br.readLine();
            if (s.equals("고무오리 디버깅 끝")) break;
            if (s.charAt(0) == '문') cnt++;
            else cnt--;
            if (cnt<0) cnt=2;
        }
        System.out.println(cnt==0?"고무오리야 사랑해":"힝구");
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
