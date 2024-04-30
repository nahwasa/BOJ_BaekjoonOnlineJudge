import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {new Main().solution();}

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();

        int s = 0;
        int e = n-1;
        while (k>0 && s<e) {
            while (s<n && arr[s] == 'P') s++;
            while (e>0 && arr[e] == 'C') e--;
            if (s<e) {
                k--;
                arr[s] = 'P';
                arr[e] = 'C';
            }
        }

        long a = 0;
        long b = 0;
        long c = 0;
        for (char cur : arr) {
            if (cur == 'P') b += a++;
            else c += b;
        }
        System.out.println(c);
    }
}
