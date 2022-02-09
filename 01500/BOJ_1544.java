import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String>[] arr = new ArrayList[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
            String cur = br.readLine();
            for (int j = 0; j < cur.length(); j++)
                arr[i].add(cur.substring(j) + cur.substring(0, j));

            boolean chk = true;
            for (int j = 0; chk && j <= i-1; j++) {
                for (int k = 0; chk && k < arr[j].size(); k++) {
                    if (cur.equals(arr[j].get(k))) chk = false;
                }
            }
            if (chk)
                cnt++;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
