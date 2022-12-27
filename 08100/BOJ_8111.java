import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            sb.append(new Main().solution()).append('\n');
        }
        System.out.print(sb);
    }

    public String solution() throws Exception {
        String input = br.readLine();
        if (isInputAll0or1(input)) {
            return input;
        }
        int n = Integer.parseInt(input);

        boolean[] v = new boolean[n+1];
        int[][] path = new int[n+1][2];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        v[1] = true;

        while (!q.isEmpty()) {
            int curNum = q.poll();
            if (curNum == 0) {
                return getAnswer(path);
            }
            for (int i = 0; i < 2; i++) {
                int nextNum = curNum*10 + i;
                nextNum %= n;
                if (v[nextNum]) continue;
                v[nextNum] = true;
                path[nextNum][0] = curNum;
                path[nextNum][1] = i;
                q.add(nextNum);
            }
        }
        return "";
    }

    private boolean isInputAll0or1(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= '2') return false;
        }
        return true;
    }

    private String getAnswer(int[][] path) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i != 1; i = path[i][0]) {
            tmp.append(path[i][1]);
        }
        tmp.append(1);
        return tmp.reverse().toString();
    }
}
