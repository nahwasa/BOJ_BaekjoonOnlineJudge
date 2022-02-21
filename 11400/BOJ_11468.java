import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int[][] cnt = new int['z'-'a'+1][2];
        for (int i = 1; i < a.length(); i++) cnt[a.charAt(i)-'a'][0]++;
        for (int i = 0; i < b.length()-1; i++) cnt[b.charAt(i)-'a'][1]++;

        long answer = 1l*a.length()*b.length();
        for (int i = 0; i < cnt.length; i++) answer-=1l*cnt[i][0]*cnt[i][1];
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
