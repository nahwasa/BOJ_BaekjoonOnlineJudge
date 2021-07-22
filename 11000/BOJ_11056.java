import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = "0" + br.readLine();
        String b = "0" + br.readLine();

        int[][] lcs = new int[a.length()][b.length()];
        for (int i = 1; i < a.length(); i++) {
            for (int j = 1; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) lcs[i][j] = lcs[i-1][j-1] + 1;
                else lcs[i][j] = lcs[i-1][j] > lcs[i][j-1] ? lcs[i-1][j] : lcs[i][j-1];
            }
        }
        int i = a.length()-1;
        int j = b.length()-1;
        System.out.println(i + j - lcs[i][j]);
    }
}
