import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static final int OPEN_BRACKET   = 2;
    private static final int TRUE           = 1;
    private static final int FALSE          = 0;

    private int getDeepestLevel(String s) {
        int maxLv = 0;
        int lv = 0;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' : lv++; stk.push(OPEN_BRACKET); break;
                case ')' : lv--; stk.pop(); break;
            }
            maxLv = Math.max(maxLv, lv);
        }
        return maxLv;
    }

    private boolean getTreeResult(String s) {
        int lv = 0;
        int maxLv = getDeepestLevel(s);
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' : lv++; stk.push(OPEN_BRACKET); break;
                case 'T' : stk.push(TRUE); break;
                case 'F' : stk.push(FALSE); break;
                case ')' :
                    int tmp = stk.pop();
                    while (stk.peek()!=OPEN_BRACKET) {
                        if (((maxLv-lv)&1) == 0) tmp &= stk.pop();
                        else tmp |= stk.pop();
                    }
                    stk.pop();
                    lv--;
                    stk.push(tmp);
                    break;
            }
        }

        return stk.pop() == 1 ? true : false;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 1;
        StringBuilder answer = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.charAt(1) == ')') break; // EOF
            answer.append(tc++).append('.').append(' ').append(getTreeResult(s) ? "true" : "false").append('\n');
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
