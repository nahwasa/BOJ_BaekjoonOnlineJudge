import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private boolean checkAndSet(ArrayList<Integer> x, ArrayList<Integer> dot, char c, int cnt) {
        if (c=='X' && cnt%2==1) {
            return false;
        }
        if (c == 'X') x.add(cnt);
        else dot.add(cnt);
        return true;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> dot = new ArrayList<>();
        int cnt = 1;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (c == cur) {
                cnt++;
                continue;
            }
            if (!checkAndSet(x, dot, c, cnt)) {
                System.out.println(-1);
                return;
            }
            c = cur;
            cnt = 1;
        }
        if (!checkAndSet(x, dot, c, cnt)) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        if (x.size()==0) {
            for (int i = 0; i < dot.get(0); i++) sb.append('.');
            System.out.println(sb);
            return;
        }
        int dotIdx = 0;
        if (s.charAt(0) == '.') {
            for (int i = 0; i < dot.get(dotIdx); i++) sb.append('.');
            dotIdx++;
        }
        for (int i = 0; i < x.size(); i++) {
            int cur = x.get(i);
            for (int j = 0; j < cur/4*4; j++) sb.append('A');
            cur%=4;
            for (int j = 0; j < cur; j++) sb.append('B');
            if (dotIdx < dot.size()) {
                for (int j = 0; j < dot.get(dotIdx); j++) sb.append('.');
                dotIdx++;
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
