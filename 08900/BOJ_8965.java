import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            final String s = br.readLine();
            Integer[] arr = new Integer[s.length()];
            for (int i = 0; i < s.length(); i++) arr[i] = i;
            Arrays.sort(arr, new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    int gap = -1;
                    int limit = s.length();
                    while (++gap < limit) {
                        int atA = (a + gap) % limit;
                        int atB = (b + gap) % limit;
                        if (s.charAt(atA) == s.charAt(atB)) continue;
                        return s.charAt(atA) - s.charAt(atB);
                    }
                    return 0;
                }
            });

            int resIdx = arr[0];
            for (int i = 0; i < s.length(); i++) result.append(s.charAt((resIdx + i) % s.length()));
            result.append('\n');
        }
        System.out.println(result);
    }
}
