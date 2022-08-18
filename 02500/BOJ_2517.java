import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
    int n;
    int[] arr, bit;
    HashMap<Integer, Integer> mapping = new HashMap<>();

    private void valueCompression(Integer[] compArr) {
        Arrays.sort(compArr, Comparator.reverseOrder());

        int comp = 1;
        int bf = compArr[0];
        for (int i = 1; i <= n; i++) {
            if (compArr[i] == bf) {
                continue;
            }
            bf = compArr[i];
            mapping.put(compArr[i], comp++);
        }
    }

    private void setCompressionValueToArr(int[] arr) {
        for (int i = 1; i <= n; i++) {
            arr[i] = mapping.get(arr[i]);
        }
    }

    private int getAnswer(int i) {
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= i&-i;
        }
        return sum;
    }

    private void update(int i) {
        while (i <= n) {
            bit[i]++;
            i += i&-i;
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        bit = new int[n+1];
        Integer[] compArr = new Integer[n+1];
        compArr[0] = 1000000001;
        for (int i = 1; i <= n; i++) {
            arr[i] = compArr[i] = Integer.parseInt(br.readLine());
        }

        valueCompression(compArr);
        setCompressionValueToArr(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(getAnswer(arr[i]-1)+1).append('\n');
            update(arr[i]);
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
