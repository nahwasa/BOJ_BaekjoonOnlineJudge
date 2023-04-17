import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String QUIT = "QUIT";
    private static final String END = "END";
    private static final String ERROR = "ERROR";

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s.equals(QUIT)) break;

            List<String> op = new ArrayList<>();
            while (true) {
                if (s.equals(END)) break;
                op.add(s);
                s = br.readLine();
            }

            int n = Integer.parseInt(br.readLine());
            while (n-->0) {
                proc(sb, op, Integer.parseInt(br.readLine()));
            }
            sb.append('\n');
            br.readLine();
        }

        System.out.print(sb);
    }

    private void proc(StringBuilder sb, List<String> op, int initNum) {
        GoStack stack = new GoStack(initNum);

        try {
            for (String cur : op) {
                if (cur.length() > 3) {
                    StringTokenizer st = new StringTokenizer(cur);
                    st.nextToken();
                    int x = Integer.parseInt(st.nextToken());
                    stack.num(x);
                    continue;
                }

                switch (cur) {
                    case "POP": stack.pop(); break;
                    case "INV": stack.inv(); break;
                    case "DUP": stack.dup(); break;
                    case "SWP": stack.swp(); break;
                    case "ADD": stack.add(); break;
                    case "SUB": stack.sub(); break;
                    case "MUL": stack.mul(); break;
                    case "DIV": stack.div(); break;
                    case "MOD": stack.mod(); break;
                }
            }
            sb.append(stack.answer()).append('\n');
        } catch (RuntimeException e) {
            sb.append(ERROR).append('\n');
        }
    }
}

class GoStack {
    private static final int LIMIT = 1000000000;
    private ArrayDeque<Integer> stack;

    private static class TwoNum {
        int a, b;

        public TwoNum(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public GoStack(int num) {
        stack = new ArrayDeque<>();
        stack.addLast(num);
    }

    private void checkIfEmpty() {
        if (stack.isEmpty())
            throw new RuntimeException();
    }

    private void checkIfOnlyOneElement() {
        if (stack.size() != 1)
            throw new RuntimeException();
    }

    private void checkIfOverLimit(int num) {
        if (Math.abs(num) > LIMIT)
            throw new RuntimeException();
    }

    private void checkIfOverLimit(long num) {
        if (Math.abs(num) > LIMIT)
            throw new RuntimeException();
    }

    private void checkIfZero(int num) {
        if (num == 0)
            throw new RuntimeException();
    }

    private TwoNum twoNum() {
        checkIfEmpty();
        int a = stack.removeLast();

        checkIfEmpty();
        int b = stack.removeLast();

        return new TwoNum(a, b);
    }


    public int answer() {
        checkIfOnlyOneElement();
        return stack.peekLast();
    }

    public void num(int x) {
        stack.addLast(x);
    }

    public void pop() {
        checkIfEmpty();
        stack.removeLast();
    }

    public void inv() {
        checkIfEmpty();
        stack.addLast(-stack.removeLast());
    }

    public void dup() {
        checkIfEmpty();
        stack.addLast(stack.peekLast());
    }

    public void swp() {
        TwoNum nums = twoNum();

        stack.addLast(nums.a);
        stack.addLast(nums.b);
    }

    public void add() {
        TwoNum nums = twoNum();
        int res = nums.a + nums.b;

        checkIfOverLimit(res);
        stack.addLast(res);
    }

    public void sub() {
        TwoNum nums = twoNum();
        int res = nums.b - nums.a;

        checkIfOverLimit(res);
        stack.addLast(res);
    }

    public void mul() {
        TwoNum nums = twoNum();
        long res = 1l * nums.a * nums.b;

        checkIfOverLimit(res);
        stack.addLast((int) res);
    }

    public void div() {
        TwoNum nums = twoNum();
        checkIfZero(nums.a);

        boolean isNegative = false;
        if (nums.a < 0) {
            isNegative = !isNegative;
            nums.a = -nums.a;
        }
        if (nums.b < 0) {
            isNegative = !isNegative;
            nums.b = -nums.b;
        }
        int res = nums.b / nums.a;

        stack.addLast(isNegative ? -res : res);
    }

    public void mod() {
        TwoNum nums = twoNum();
        checkIfZero(nums.a);

        boolean isNegative = false;
        if (nums.a < 0) {
            nums.a = -nums.a;
        }
        if (nums.b < 0) {
            isNegative = !isNegative;
            nums.b = -nums.b;
        }
        int res = nums.b % nums.a;

        stack.addLast(isNegative ? -res : res);
    }
}
