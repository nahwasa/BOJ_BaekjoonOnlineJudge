import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        String s = st.nextToken();
        ArrayList<String>[] arr = new ArrayList[81];
        for (int i = 4; i <= 80; i++) arr[i] = new ArrayList<>();
        while (d-->0) {
            String cur = br.readLine();
            if (cur.length()<=3) continue;
            arr[cur.length()].add(cur);
        }
        Queue<String> q = new ArrayDeque<>();
        q.add(s);
        String answer = null;
        HashSet<String>[] hs = new HashSet[81];
        for (int i = 4; i <= 80; i++) hs[i] = new HashSet<>();
        while (!q.isEmpty()) {
            String cur = answer = q.poll();
            for (String next : arr[cur.length()+1]) {
                if (hs[next.length()].contains(next)) continue;
                int defCnt = 0;
                for (int i = 0, j = 0; i < cur.length() && j < next.length() && defCnt <= 1; ) {
                    if (cur.charAt(i) != next.charAt(j)) {
                        defCnt++;
                        j++;
                    } else {
                        i++;
                        j++;
                    }
                }
                if (defCnt <= 1) {
                    q.add(next);
                    hs[next.length()].add(next);
                }
            }
        }
        bw.write(answer);
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
