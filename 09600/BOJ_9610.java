import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int q1=0,q2=0,q3=0,q4=0,axis=0;
        while (n-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x == 0 || y == 0)
                axis++;
            if (x>0&&y>0)
                q1++;
            if (x<0&&y<0)
                q3++;
            if (x>0&&y<0)
                q4++;
            if (x<0&&y>0)
                q2++;
        }
        System.out.println(String.format("Q1: %d\nQ2: %d\nQ3: %d\nQ4: %d\nAXIS: %d\n", q1,q2,q3,q4,axis));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
