import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];
        int[] a = new int[2];
        int[] b = new int[2];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for(int j = 1; j <= n; j++) {
                switch(s.charAt((j-1)*2)) {
                    case '1': arr[i][j] = 1; break;
                    case '2': a[0]=i; a[1]=j; break;
                    case '5': b[0]=i; b[1]=j; break;
                }
                arr[i][j] += arr[i][j-1];
            }
        }
        if ((a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1])<25){
            System.out.println(0);
            return;
        }
        int rs = a[0]<b[0]?a[0]:b[0];
        int re = a[0]<b[0]?b[0]:a[0];
        int cs = a[1]<b[1]?a[1]:b[1];
        int ce = a[1]<b[1]?b[1]:a[1];
        int cnt = 0;
        for (int i = rs; i <= re; i++) cnt += arr[i][ce]-arr[i][cs-1];
        System.out.println(cnt>=3?1:0);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
