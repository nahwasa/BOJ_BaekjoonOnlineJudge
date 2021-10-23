import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    private static class Str {
        String a;
        int x;
        double score;
        public Str(String a, int x) {
            this.a = a;
            this.x = x;
            score = 1.0 * x / a.length();
        }
    }

    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int m = Integer.parseInt(br.readLine());

        ArrayList<Str> arr = new ArrayList<>();
        while (m-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            if (a.length() >= x)
                continue;

            arr.add(new Str(a, x));
        }

        Collections.sort(arr, new Comparator<Str>() {
            @Override
            public int compare(Str o1, Str o2) {
                double gap = o2.score - o1.score;
                if (gap < 0)
                    return -1;
                if (gap > 0)
                    return 1;
                return 0;
            }
        });

        int answer = 0;
        for (int i = 0; i < arr.size(); i++) {Str cur = arr.get(i);
            while (s.contains(cur.a)) {
                s = s.replaceFirst(cur.a, "_");
                answer += cur.x;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '_')
                answer++;
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
