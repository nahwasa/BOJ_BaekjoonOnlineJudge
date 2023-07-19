import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        while(n-->0) {
            switch (br.readLine().charAt(0)) {
                case 'P': sum+=1500; break;
                case 'M': sum+=6000; break;
                case 'S': sum+=15500; break;
                case 'C': sum+=40000; break;
                case 'T': sum+=75000; break;
                case 'H': sum+=125000; break;
            }
        }

        System.out.println(sum);
    }
}
