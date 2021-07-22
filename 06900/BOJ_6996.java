import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())   return false;
        int len = a.length();
        int[] cnt = new int['z' - 'a' + 1];
        for (int i = 0; i < len; i++) {
            cnt[a.charAt(i)-'a']++;
            cnt[b.charAt(i)-'a']--;
        }
        for (int i = 0; i < cnt.length; i++)
            if (cnt[i] != 0)    return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(tc-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            sb.append(a).append(" & ").append(b).append(" are ");
            if (!isAnagram(a, b))
                sb.append("NOT ");
            sb.append("anagrams.").append('\n');
        }
        System.out.println(sb);
    }
}
