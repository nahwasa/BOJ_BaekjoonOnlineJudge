import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s1 = "0" + br.readLine();
		String s2 = "0" + br.readLine();
		
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
		
		int i = s1.length()-1;
		int j = s2.length()-1;
		bw.write(lcs[i][j] + "\n");
		
		Stack<Character> s = new Stack<Character>();
		
		while (lcs[i][j] != 0) {
			if (lcs[i][j] == lcs[i-1][j])
				i--;
			else if (lcs[i][j] == lcs[i][j-1])
				j--;
			else if (lcs[i][j] -1 == lcs[i-1][j-1]) {
				s.push(s1.charAt(i));
				i--;
				j--;
			}
				
		}
		
		while (!s.isEmpty()) {
			bw.write(s.pop());
		}
		bw.newLine();
		
		bw.flush();
		bw.close();
		br.close();
	}

}
