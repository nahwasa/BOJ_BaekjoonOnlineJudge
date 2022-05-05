import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static boolean chk = false;
    private void print(int a, int b) {
        System.out.println(a + " " + b);
        chk = true;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        switch (str) {
            case "AABB" : if (q==7)             print(8, 9); break;
            case "ABAB" : if (p==6 && q==8)     print(7, 9); break;
            case "ABBA" : if (p+3==q)           print(p+1, p+2); break;
            case "BAAB" : if (p==2 && q==8)     print(1, 9); break;
            case "BABA" : if (p==2 && q==4)     print(1, 3); break;
            case "BBAA" : if (p==3)             print(1, 2); break;
        }
        if (!chk) System.out.println(-1);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
