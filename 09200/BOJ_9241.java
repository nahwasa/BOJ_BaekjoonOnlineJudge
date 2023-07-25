import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String a = br.readLine();
        String b = br.readLine();

        int s = 0;
        int minLen = Math.min(a.length(), b.length());
        while (s<minLen && a.charAt(s) == b.charAt(s)) {
            s++;
        }

        int e = 0;
        while (e<minLen && a.charAt(a.length()-1-e) == b.charAt(b.length()-1-e)) {
            e++;
        }

        System.out.println(s>=minLen-e?(a.length()>b.length()?0:b.length()-a.length()):b.length()-e-s);
    }
}
