import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());
        boolean swt = false;
        char op = 0;
        if (arr[0] + arr[1] == arr[2]) {
            swt = true;
            op = '+';
        } else if (arr[0] - arr[1] == arr[2]) {
            swt = true;
            op = '-';
        } else if (arr[0] * arr[1] == arr[2]) {
            swt = true;
            op = '*';
        } else if (arr[0] % arr[1] == 0 && arr[0] / arr[1] == arr[2]) {
            swt = true;
            op = '/';
        } else if (arr[2] + arr[1] == arr[0]) {
            swt = false;
            op = '+';
        } else if (-arr[2] + arr[1] == arr[0]) {
            swt = false;
            op = '-';
        } else if (arr[2] * arr[1] == arr[0]) {
            swt = false;
            op = '*';
        } else if (arr[1] % arr[2] == 0 && arr[1] / arr[2] == arr[0]) {
            swt = false;
            op = '/';
        }

        if (swt) {
            System.out.println(String.format("%d%c%d=%d", arr[0], op, arr[1], arr[2]));
        } else {
            System.out.println(String.format("%d=%d%c%d", arr[0], arr[1], op, arr[2]));
        }
    }
}
