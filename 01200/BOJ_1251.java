import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        String s = br.readLine();
        int len = s.length();
        List<String> arr = new ArrayList<>();
        for (int a = 1; a < len; a++) {
            for (int b = a+1; b < len; b++) {
                arr.add(getWord(s, a, b));
            }
        }
        Collections.sort(arr);
        System.out.println(arr.get(0));
    }

    private String getWord(final String s, final int a, final int b) {
        StringBuilder s1 = new StringBuilder(s.substring(0, a));
        StringBuilder s2 = new StringBuilder(s.substring(a, b));
        StringBuilder s3 = new StringBuilder(s.substring(b));
        StringBuilder sb = new StringBuilder();
        sb.append(s1.reverse()).append(s2.reverse()).append(s3.reverse());
        return sb.toString();
    }
}
