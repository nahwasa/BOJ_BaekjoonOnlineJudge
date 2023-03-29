import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            String cur = br.readLine();
            int cnt = 0;
            for (int i = 0; i < cur.length(); i++) {
                switch (cur.charAt(i)) {
                    case 'a': case 'e': case 'i': case 'o': case 'u': cnt++;
                }
            }
            sb.append("The number of vowels in "+ cur +" is ").append(cnt).append('.').append('\n');
        }

        System.out.print(sb);
    }
}
