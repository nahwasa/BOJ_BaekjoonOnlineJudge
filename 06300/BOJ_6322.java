import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a==0&&b==0&&c==0) break;
            sb.append("Triangle #"+n++).append('\n');
            if (c == -1) {
                sb.append(String.format("c = %.3f\n\n", Math.sqrt(a*a+b*b)));
                continue;
            }

            int tmp = 0;
            if (a == -1) tmp = c * c - b * b;
            else tmp = c * c - a * a;
            if (tmp <= 0) {
                sb.append("Impossible.\n\n");
                continue;
            }

            sb.append((a==-1?"a":"b") + String.format(" = %.3f\n\n", Math.sqrt(tmp)));
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
