import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1000; i < 10000; i++) {
			int tmp = cnt(String.valueOf(i));
			if (tmp != cnt(Integer.toString(i, 12))) continue;
			if (tmp != cnt(Integer.toString(i, 16))) continue;
			bw.write(i + "\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
	private static int cnt(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)>='0' && s.charAt(i)<='9')
				result+=(s.charAt(i)-'0');
			else
				result+=(s.charAt(i)-'a'+10);
		}
		return result;
	}
}
