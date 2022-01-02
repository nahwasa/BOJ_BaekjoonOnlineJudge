import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private char getShiftedChar(char c, int[] cnt) {
        int maxCnt = 0;
        int maxIdx = 0;

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > maxCnt) {
                maxCnt = cnt[i];
                maxIdx = i;
            }
        }

        int charNum = c-'a'+maxIdx+1;
        charNum %= 26;

        return (char)('a'+charNum);
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String s = br.readLine();
        if (s.length() <= k) {
            System.out.println(s);
            return;
        }

        StringBuilder answer = new StringBuilder();
        int[] cnt = new int['z'-'a'+1];
        for (int i = 0; i < k; i++) {
            cnt[s.charAt(i)-'a']++;
            answer.append(s.charAt(i));
        }

        for (int i = k; i < s.length(); i++) {
            answer.append(getShiftedChar(s.charAt(i), cnt));
            cnt[s.charAt(i-k)-'a']--;
            cnt[s.charAt(i)-'a']++;
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
