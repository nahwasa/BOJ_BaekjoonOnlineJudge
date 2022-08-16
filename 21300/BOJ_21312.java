import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int answer = 0;

    private void setAnswer(int cur) {
        if (answer%2==1 && cur%2==0) {
            return;
        }
        if (answer%2==0 && cur%2==1) {
            answer = cur;
            return;
        }
        if (answer < cur)
            answer = cur;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        setAnswer(a);
        setAnswer(b);
        setAnswer(c);
        setAnswer(a*b);
        setAnswer(b*c);
        setAnswer(a*c);
        setAnswer(a*b*c);

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
