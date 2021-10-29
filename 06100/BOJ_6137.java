import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        int n = nextInt();
        char[] arr = new char[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextLine().charAt(0);

        int head = 0;
        int tail = n-1;
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            boolean isHead = true;
            for (int i = 0; i < (tail-head+1)/2; i++) {
                if (arr[head+i] == arr[tail-i]) continue;
                if (arr[head+i] < arr[tail-i]) isHead = true;
                else isHead = false;
                break;
            }
            sb.append(isHead ? arr[head++] : arr[tail--]);
            if (sb.length() == 80) {
                System.out.println(sb);
                sb = new StringBuilder();
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }


    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringBuilder answer = new StringBuilder();

    private int nextInt() throws Exception {return Integer.parseInt(nextLine());}
    private String nextLine() throws Exception {return br.readLine();}
}
