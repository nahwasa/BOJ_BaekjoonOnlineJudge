import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private int type(char c) {
        switch (c) {
            case'a': case'e': case'i': case'o': case'u' : return 1;
            default: return -1;
        }
    }
    private boolean checkIt(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (type(s.charAt(i)) == 1) break;
            if (i == s.length()-1) return false;
        }
        int chk = 0;
        for (int i = 0; i < s.length(); i++) {
            int type = type(s.charAt(i));
            if (type > 0 && chk > 0) chk++;
            else if (type < 0 && chk < 0) chk--;
            else chk = type;
            if (Math.abs(chk) == 3) return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) == s.charAt(i) && s.charAt(i) != 'e' && s.charAt(i) != 'o') return false;
        }

        return true;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("end")) break;
            sb.append(String.format(checkIt(s)?"<%s> is acceptable.\n":"<%s> is not acceptable.\n", s));
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
