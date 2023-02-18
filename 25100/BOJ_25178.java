import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int n;
    private String a, b;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        n = Integer.parseInt(br.readLine());
        a = br.readLine();
        b = br.readLine();

        System.out.println(isRule1Satisfied() && isRule2Satisfied() && isRule3Satisfied() ? "YES" : "NO");
    }

    private boolean isRule1Satisfied() {
        int[] cnt = new int['Z'-'A'+1];
        for (int i = 0; i < n; i++) {
            cnt[a.charAt(i)-'a']++;
            cnt[b.charAt(i)-'a']--;
        }
        for (int i = 0; i < 'Z'-'A'+1; i++) {
            if (cnt[i] != 0)
                return false;
        }
        return true;
    }

    private boolean isRule2Satisfied() {
        return a.charAt(0) == b.charAt(0) && a.charAt(n-1) == b.charAt(n-1);
    }

    private boolean isRule3Satisfied() {
        String replacedA = a.replaceAll("[aeiou]", "");
        String replacedB = b.replaceAll("[aeiou]", "");
        return replacedA.equals(replacedB);
    }
}
