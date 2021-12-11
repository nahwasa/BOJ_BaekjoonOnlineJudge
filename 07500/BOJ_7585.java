import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private boolean isLegalBrackets(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' : case '[' : case '{' : stk.push(s.charAt(i)); break;
                case ')' : if (stk.pop() != '(') return false; break;
                case ']' : if (stk.pop() != '[') return false; break;
                case '}' : if (stk.pop() != '{') return false; break;
            }
        }
        if (stk.isEmpty()) return true;
        return false;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("#")) break;

            sb.append(isLegalBrackets(s) ? "Legal\n" : "Illegal\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
