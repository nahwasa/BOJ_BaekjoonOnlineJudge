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
		int cntJ = 0;
		int cntI = 0;
	
		for (int i = 1; i < s.length()-1; i++) {
			if (s.charAt(i) == 'O' && s.charAt(i+1) == 'I') {
				if (s.charAt(i-1) == 'J')
					cntJ++;
				else if (s.charAt(i-1) == 'I')
					cntI++;
			}
		}
		bw.write(cntJ + "\n" + cntI + "\n");
		
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
