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
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(c);
			}
			bw.write(sb.toString());
			bw.newLine();
		}		
		bw.flush();
		br.close();
		bw.close();		
	}
}
