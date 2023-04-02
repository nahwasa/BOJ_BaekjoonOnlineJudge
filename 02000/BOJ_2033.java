import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String str = br.readLine();
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[str.length()-i-1] = str.charAt(i) - '0';
        }

        for (int i = 0; i < arr.length-1; i++) {
            arr[i+1] += arr[i]>=5?1:0;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr[arr.length-1]);
        for (int i = 0; i < str.length()-1; i++) {
            sb.append('0');
        }
        System.out.println(sb);
    }
}
