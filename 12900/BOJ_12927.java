import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean[] arr = new boolean[s.length()+1];
        for (int i = 0; i < s.length(); i++)
            arr[i+1] = s.charAt(i)=='Y';

        int cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i]) continue;
            cnt++;
            for (int j = i; j < arr.length; j+=i)
                arr[j] = !arr[j];
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
