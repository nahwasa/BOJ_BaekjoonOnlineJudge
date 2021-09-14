import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final char[] OP = {'+','-','*','/'};
    private static StringTokenizer st;
    private static int ni() { return Integer.parseInt(st.nextToken()); }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine se = sem.getEngineByName("JavaScript");
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= 1; i++) {
            for (int op = 0; op < OP.length; op++) {
                if (op == 3 && arr[i]%arr[i+1]!=0) continue;
                String formula = String.format("%d%c%d", arr[i], OP[op], arr[i+1]);
                int res = Integer.parseInt(String.valueOf(se.eval(formula)));
                if (arr[(i+2)%3] == res) {
                    System.out.println( (i==0?"":res+"=") + formula + (i==1?"":"="+res) );
                    return;
                }
            }
        }
    }
}
