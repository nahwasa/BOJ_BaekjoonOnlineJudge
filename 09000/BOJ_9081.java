import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while(t-->0) {
            String s = br.readLine();
            int[] cnt = new int['z'-'a'+1];
            char bf = s.charAt(s.length()-1);
            cnt[s.charAt(s.length()-1)-'A']++;
            int i = s.length()-2;
            int downIdxCharAscii = 0;
            for (; i >= 0; i--) {
                char cur = s.charAt(i);
                cnt[cur-'A']++;
                if (cur < bf) {
                    downIdxCharAscii = cur-'A';
                    break;
                }
                bf = cur;
            }

            if (i < 0) {
                answer.append(s).append('\n');
                continue;
            }

            for (int j = 0; j < i; j++)
                answer.append(s.charAt(j));

            for (int j = downIdxCharAscii+1; j < cnt.length; j++) {
                if (cnt[j] > 0) {
                    cnt[j]--;
                    answer.append((char)('A'+j));
                    break;
                }
            }

            for (int j = 0; j < cnt.length; j++) {
                for (int k = 0; k < cnt[j]; k++) {
                    answer.append((char)('A'+j));
                }
            }
            answer.append('\n');
        }
        System.out.print(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
