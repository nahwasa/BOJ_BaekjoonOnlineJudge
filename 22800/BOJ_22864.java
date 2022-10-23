import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int sum = 0;
        int aSum = 0;
        for (int i = 0; i < 24; i++) {
        	if (aSum+a <= m) {
        		sum += b;
        		aSum += a;
        	} else {
        		aSum -= c;
        		if (aSum < 0)
        			aSum = 0;
        	}
        }
        System.out.print(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
