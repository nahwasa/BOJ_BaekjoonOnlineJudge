import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] score = {6,3,2,1,2};
        int tc = 2;
        while (tc-->0) {
            int sum = 0;
            String[] arr = br.readLine().split(" ");
            for (int i = 0; i < score.length; i++) {
                sum += Integer.parseInt(arr[i]) * score[i];
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
