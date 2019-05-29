import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), "0");
		
		for (int i = 0; i < 2; i++) {
			String s = st.nextToken();
			int cnt = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '@')
					cnt++;
			}
			bw.write(String.valueOf(cnt));
			if (i == 0)
				bw.write(" ");
			else
				bw.write("\n");
		}
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
