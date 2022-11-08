import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[13];
        String base = "9780921418948";
        for (int i = 0; i < 10; i++)
            arr[i] = base.charAt(i)-'0';
        arr[10] = Integer.parseInt(br.readLine());
        arr[11] = Integer.parseInt(br.readLine());
        arr[12] = Integer.parseInt(br.readLine());

        int sum = 0;
        boolean is1 = false;
        for (int i = 0; i < 13; i++) {
            sum += (is1=!is1)?arr[i]:3*arr[i];
        }
        System.out.println("The 1-3-sum is " + sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
