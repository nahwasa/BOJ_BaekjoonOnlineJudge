import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String s = "";
        StringBuilder sb = new StringBuilder();
        while ( (s = br.readLine()) != null ) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch (c) {
                    case 'i' : c = 'e'; break;
                    case 'e' : c = 'i'; break;
                    case 'I' : c = 'E'; break;
                    case 'E' : c = 'I'; break;
                }

                sb.append(c);
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
