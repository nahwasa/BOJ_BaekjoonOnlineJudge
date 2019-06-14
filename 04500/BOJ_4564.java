import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			String s = br.readLine();
			if (s.equals("0"))
				break;
			bw.write(s + " ");
			if (s.length() == 1) {
				bw.newLine();
				continue;
			}
			while (true) {
				int tmp = 1;
				for (int i = 0; i < s.length(); i++) {
					tmp *= (s.charAt(i) - '0');
				}
				s = String.valueOf(tmp);
				bw.write(s + " ");
				if (tmp < 10)
					break;
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
