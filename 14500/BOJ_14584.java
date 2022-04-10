import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int n = Integer.parseInt(br.readLine());
        String[] chk = new String[n];
        for (int i = 0; i < n; i++)
            chk[i] = br.readLine();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[j] = (char)('a'+((arr[j]-'a'+1)%26));
            }
            String s = String.valueOf(arr);
            for (int j = 0; j < n; j++) {
                if (s.contains(chk[j])) {
                    System.out.println(s);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
