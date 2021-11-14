import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private int hexToDec(char hex) {
        if (hex<='9') return hex-'0';
        return 10+hex-'A';
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        StringBuilder answer = new StringBuilder();
        while ((s=br.readLine()) != null) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length/2; i++) {
                answer.append( (char)(16*hexToDec(arr[i*2]) + hexToDec(arr[i*2+1])) );
            }
            answer.append('\n');
        }
        System.out.print(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
