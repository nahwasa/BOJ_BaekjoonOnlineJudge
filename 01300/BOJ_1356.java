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
		boolean chk = false;
		for (int i = 1; i < s.length(); i++) {
			int mul1 = 1;
			for (int j = 0; j < i; j++)
				mul1*=(s.charAt(j)-'0');
			int mul2 = 1;
			for (int j = i; j < s.length(); j++)
				mul2*=(s.charAt(j)-'0');
			if (mul1 == mul2) {
				chk = true;
				break;
			}
		}
		if (chk)
			bw.write("YES\n");
		else
			bw.write("NO\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
