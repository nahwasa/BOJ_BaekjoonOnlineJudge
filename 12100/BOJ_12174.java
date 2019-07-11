import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				String tmp = new String();
				for (int j = i*8; j < i*8+8; j++)
					tmp += (input.charAt(j)=='O'?'0':'1');
				int charNum = Integer.parseInt(tmp, 2);
				sb.append((char)charNum);
			}
			bw.write(String.format("Case #%d: %s\n", tc, sb.toString()));
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
