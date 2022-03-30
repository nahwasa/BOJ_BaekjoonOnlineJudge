import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    int[] opPriority = new int[50];
    private void init() {
        opPriority['*'] = opPriority['/'] = 1;
        opPriority['('] = opPriority[')'] = -1;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A') {
                sb.append(c);
                continue;
            }
            if (c == '(') {
                stk.add(c);
                continue;
            }
            if (c == ')') {
                while (stk.peek() != '(') {
                    sb.append(stk.pop());
                }
                stk.pop();
                continue;
            }
            while (!stk.isEmpty() && opPriority[stk.peek()] >= opPriority[c]) {
                sb.append(stk.pop());
            }
            stk.add(c);
        }
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
