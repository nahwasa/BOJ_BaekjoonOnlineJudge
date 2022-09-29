import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int A_TO_Z = 'z'-'a'+1;
    private boolean isFake(String msg) {
        int[] cnt = new int[A_TO_Z];
        for (int i = 0; i < msg.length(); i++) {
            int idx = msg.charAt(i)-'A';
            cnt[idx]++;
            if (cnt[idx] == 3) {
                if (i == msg.length()-1 || msg.charAt(i+1) != msg.charAt(i))
                    return true;
                cnt[idx] = 0;
                i++;
            }
        }
        return false;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            sb.append(isFake(br.readLine()) ? "FAKE\n" : "OK\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
