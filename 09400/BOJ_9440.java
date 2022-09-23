import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private long getAnswer(int n, int zeroCnt, ArrayList<Integer> arr) {
        Collections.sort(arr);

        // 남은 갯수를 짝수로 만들어줌
        long answer = n%2 == 0 ? 0 : arr.get(0)*10;
        int idx = n%2 == 0 ? 0 : 1;

        // 숫자의 처음이 0이 되지 않도록 예외처리 해줌
        if (zeroCnt>0) {
            if (n%2 == 0) {
                answer += arr.get(idx) + arr.get(idx+1);
                idx += 2;
            } else {
                answer += arr.get(idx);
                idx += 1;
                zeroCnt-=1;
            }
            answer*=10;
        }

        // 남은 '0' 처리
        while (zeroCnt >= 2) {
            answer*=10;
            zeroCnt-=2;
        }
        if (zeroCnt == 1) {
            answer += arr.get(idx);
            answer*=10;
            idx++;
        }

        // 이하 숫자의 첫 시작이 0으로 시작되지 않으며, 남은 수는 짝수이므로 자리수마다 2개씩 골라주면 끝임.
        for (;idx < arr.size(); idx+=2) {
            answer += arr.get(idx) + arr.get(idx+1);
            answer*=10;
        }
        return answer/10;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            ArrayList<Integer> arr = new ArrayList<>();
            int zeroCnt = 0;
            for (int i = 0; i < n; i++) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur == 0) {
                    zeroCnt++;
                    continue;
                }
                arr.add(cur);
            }
            sb.append(getAnswer(n, zeroCnt, arr)).append('\n');
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
