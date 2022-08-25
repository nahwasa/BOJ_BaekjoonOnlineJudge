import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String s = br.readLine();
        int cnt = 0;
        int cntL = 0;
        int cntS = 0;
        boolean chk = true;
        for (int i = 0; chk && i < s.length(); i++) {
            chk = true;
            switch (s.charAt(i)) {
                case 'L': cntL++; break;
                case 'S': cntS++; break;
                case 'R': if(cntL==0) chk=false; else {cnt++; cntL--;} break;
                case 'K': if(cntS==0) chk=false; else {cnt++; cntS--;} break;
                default: cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
