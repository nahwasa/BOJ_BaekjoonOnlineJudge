import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String N = st.nextToken();
		int nLength = Integer.parseInt(N) * N.length();
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		while (true) {
			for (int i = 0; i < N.length(); i++) {
				sb.append(N.charAt(i));
				if (sb.length() >= M || sb.length() >= nLength)
					break;
			}
		if (sb.length() >= M || sb.length() >= nLength)
			break;
		}
		bw.write(sb.toString()+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
