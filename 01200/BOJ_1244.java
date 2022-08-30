import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = st.nextToken().charAt(0)=='0'?false:true;
        int k = Integer.parseInt(br.readLine());
        while (k-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            switch (a) {
                case 1:
                    int tmp = b;
                    while (tmp <= n) {
                        arr[tmp] = !arr[tmp];
                        tmp += b;
                    }
                    break;
                case 2 :
                    arr[b] = !arr[b];
                    int len = Math.min(b-1, n-b);
                    for (int i = 1; i <= len; i++) {
                        if (arr[b-i] != arr[b+i]) break;
                        arr[b-i] = !arr[b-i];
                        arr[b+i] = !arr[b+i];
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]?1:0).append(' ');
            cnt++;
            if (cnt == 20) {
                cnt = 0;
                System.out.println(sb);
                sb = new StringBuilder();
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
