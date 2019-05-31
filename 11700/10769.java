import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		
		if ((!s.contains(":-)") && !s.contains(":-(")) || s.length() < 3) {
			bw.write("none\n");
			bw.flush();
			br.close();
			bw.close();		
			return;
		}
						
		int happyCnt = 0;
		int sadCnt = 0;
		
		for (int i = 0; i < s.length()-2; i++) {
			if (s.charAt(i) == ':' && s.charAt(i+1) == '-') {
				if (s.charAt(i+2) == ')') {
					happyCnt++;
					i += 2;
				} else if (s.charAt(i+2) == '(') {
					sadCnt++;
					i += 2;
				} else
					i++;
			}
		}

		if (happyCnt == sadCnt)
			bw.write("unsure\n");
		else if (happyCnt > sadCnt)
			bw.write("happy\n");
		else
			bw.write("sad\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
