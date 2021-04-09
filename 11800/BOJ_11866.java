import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++)    q.add(i);
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int cnt = k;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            if (--cnt>0) {
                q.add(tmp);
                continue;
            }
            cnt = k;
            sb.append(tmp);
            if (!q.isEmpty())   sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
