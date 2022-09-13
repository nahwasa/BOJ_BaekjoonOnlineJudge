import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int LENGTH_OF_A_TO_Z = 'z'-'a'+1;
    private int atoi(char c) {return c-'a';}
    private boolean isGroupWord(String s) {
        int[] cnt = new int[LENGTH_OF_A_TO_Z];
        char bf = '\0';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (bf==c) continue;
            bf = c;
            if (++cnt[atoi(c)]==2) return false;
        }
        return true;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        while (n-->0)
            if (isGroupWord(br.readLine())) answer++;
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
