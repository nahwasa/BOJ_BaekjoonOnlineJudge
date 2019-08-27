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
		boolean isFA = false;
		int maxTry = 10000;
		while (maxTry-->0) {
			int tmp = (s.charAt(0)-'0') * s.length();
			String s2 = String.valueOf(tmp);
			if (s.equals(s2)) {
				isFA = true;
				break;
			}
			s = s2;			
		}
		bw.write(isFA?"FA\n":"NFA\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
