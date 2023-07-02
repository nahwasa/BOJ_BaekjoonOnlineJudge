import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int a = 0;
        for (int i = 0; i < 10; i++) {
            int t = Integer.parseInt(br.readLine());

            switch (t) {
                case 1 : a++; break;
                case 2 : a+=2; break;
                case 3 : a--; break;
            }
        }

        while (a<0) a+=4;
        a%=4;
        
        char answer = 'N';
        if (a == 1) answer = 'E';
        if (a == 2) answer = 'S';
        if (a == 3) answer = 'W';

        System.out.println(answer);
    }
}
