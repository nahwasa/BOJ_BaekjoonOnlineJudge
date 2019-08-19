import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		while (true) {
			String s = br.readLine();
			if (s.equals("0")) break;
			while (s.length()>=2) {
				int sum = 0;
				for (int i = 0; i < s.length(); i++)
					sum += s.charAt(i)-'0';
				s = String.valueOf(sum);
			}			
			bw.write(s + "\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
