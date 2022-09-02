import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int a = p>q?p:q;
        int b = p>q?q:p;
        if (b == 1 || b == 2 && d%2==0 || d%a==0 || d%b==0) {System.out.println(d); return;}

        int limit = d/a+1;
        int answer = a-1;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i <= limit; i++) {
            int remain = d-a*i;
            if (remain>0 && remain%b == 0) {
                System.out.println(d);
                return;
            }
            if (remain < 0) remain+=b;
            int tmp = b-remain%b;

            if (hs.contains(tmp)) break;
            hs.add(tmp);
            if (answer > tmp)
                answer = tmp;
        }
        System.out.println(d+answer);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
