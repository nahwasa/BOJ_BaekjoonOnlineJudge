import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private boolean getResult(int a, int b, String op) {
        switch (op) {
            case ">":   return a>b;
            case ">=":  return a>=b;
            case "<":   return a<b;
            case "<=":  return a<=b;
            case "==":  return a==b;
            case "!=":  return a!=b;
        }
        return false;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            if (op.equals("E")) break;
            sb.append(String.format("Case %d: %s\n", t++,getResult(a, b, op)?"true":"false"));
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
