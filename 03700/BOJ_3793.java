import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {	

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String s1 = "0" + sc.next();
			String s2 = "0" + sc.next();
			
			int[][] lcs = new int[s1.length()][s2.length()];

			for (int i = 1; i < s1.length(); i++) {
				for (int j = 1; j < s2.length(); j++) {

					if (s1.charAt(i) == s2.charAt(j)) {
						lcs[i][j] = lcs[i-1][j-1] + 1;
					} else {
						lcs[i][j] = lcs[i-1][j] > lcs[i][j-1] ? lcs[i-1][j] : lcs[i][j-1];
					}

				}
			}
			System.out.println(lcs[s1.length()-1][s2.length()-1]);
		}		
		
		sc.close();
	}

}
