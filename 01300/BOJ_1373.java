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
		StringBuilder result = new StringBuilder();
		if (s.length()%3 == 1)
			s = "00" + s;
		else if (s.length()%3 == 2)
			s = "0" + s;
		for (int i = 0; i < s.length()/3; i++) {
			int sum = (s.charAt(i*3) - '0')*4
					+ (s.charAt(i*3+1) - '0')*2
					+ (s.charAt(i*3+2) - '0');
			result.append(sum);
		}
		bw.write(result.toString());		
		bw.flush();
		br.close();
		bw.close();		
	}
}
