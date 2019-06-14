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
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if (N == 0)
				break;
			String tmp = st.nextToken();
			bw.write(tmp + " ");
			N--;
			while (N-->0) {
				String in = st.nextToken();
				if (!tmp.equals(in)) {
					bw.write(in + " ");
					tmp = in;
				}
			}
			bw.write("$\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
