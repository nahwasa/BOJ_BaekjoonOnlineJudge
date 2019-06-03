import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			String s = br.readLine();
			if (s.equals("*"))
				break;
			
			if (s.length() <= 2) {
				bw.write(s + " is surprising.\n");
				continue;
			}
			
			boolean chk = true;
			for (int i = 0; i <= s.length()-2; i++) {	//i means D
				if (!isSurprising(s, i)) {
					chk = false;
					break;
				}					
			}
			
			if (chk)
				bw.write(s + " is surprising.\n");
			else
				bw.write(s + " is NOT surprising.\n");
		}
		
		bw.flush();		
		bw.close();
		br.close();
	}

	private static boolean isSurprising(String s, int g) {
		HashSet<String> hs = new HashSet<String>();
		for (int i = 0; i < s.length() - g - 1; i++) {
			String plus = "" + s.charAt(i) + s.charAt(i + g + 1);
			if (hs.contains(plus))
				return false;
			else
				hs.add(plus);
		}		
		return true;
	}
}	
