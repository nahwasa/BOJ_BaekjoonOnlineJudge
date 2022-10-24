import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final String[] FROM = {
            "aoz",
            "ejp mysljylc kd kxveddknmc re jsicpdrysi",
            "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd",
            "de kr kd eoya kw aej tysr re ujdr lkgc jv"
    };
    private static final String[] TO = {
            "yeq",
            "our language is impossible to understand",
            "there are twenty six factorial possibilities",
            "so it is okay if you want to just give up"
    };
    char[] mapping;
    private int atoi(char c) {return c-'a';}

    private void init() {
        mapping = new char['Z'-'A'+1];
        for (int i = 0; i < FROM.length; i++) {
            String from = FROM[i];
            String to  = TO[i];
            for (int j = 0; j < from.length(); j++) {
                if (from.charAt(j)>='a'&&from.charAt(j)<='z')
                    mapping[atoi(from.charAt(j))] = to.charAt(j);
            }
        }
        mapping[atoi('q')] = 'z';
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
            String cur = br.readLine();
            sb.append(String.format("Case #%d: ", tc));
            for (int i = 0; i < cur.length(); i++) {
                char c = cur.charAt(i);
                sb.append(c>='a'&&c<='z' ? mapping[atoi(c)] : c);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
