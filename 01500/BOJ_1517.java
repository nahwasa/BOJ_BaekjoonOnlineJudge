import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

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

    private long getAnswer(int i) {
        long sum = 0;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = compArr[i] = Integer.parseInt(st.nextToken());
        }

        valueCompression(compArr);
        setCompressionValueToArr(arr);

        long answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += getAnswer(arr[i]-1);
            update(arr[i]);
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
