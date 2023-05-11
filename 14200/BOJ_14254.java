import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Math.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        char[] str = br.readLine().toCharArray();
        int k = Integer.parseInt(br.readLine());

        int answer = 0;
        int gap = str.length-k;

        for (int i = 0; i < gap; i++) {
            int sum = 0;
            int max = 0;
            int[] cnt = new int['z'-'a'+1];

            for (int j = i; j < str.length; j+=gap) {
                sum++;
                max = max(max, ++cnt[str[j]-'a']);
            }

            answer += sum-max;
        }

        System.out.println(answer);
    }
}
