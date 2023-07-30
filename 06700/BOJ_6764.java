import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) arr[i] = Integer.parseInt(br.readLine());

        if (allSame(arr)) System.out.println("Fish At Constant Depth");
        else if (inc(arr)) System.out.println("Fish Rising");
        else if (dec(arr)) System.out.println("Fish Diving");
        else System.out.println("No Fish");
    }

    private boolean allSame(int[] arr) {
        for (int i = 1; i < 4; i++)
            if (arr[i-1] != arr[i]) return false;

        return true;
    }

    private boolean inc(int[] arr) {
        for (int i = 1; i < 4; i++)
            if (arr[i-1] >= arr[i]) return false;

        return true;
    }

    private boolean dec(int[] arr) {
        for (int i = 1; i < 4; i++)
            if (arr[i-1] <= arr[i]) return false;

        return true;
    }
}
