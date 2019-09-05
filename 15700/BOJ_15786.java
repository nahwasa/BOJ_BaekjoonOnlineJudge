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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String base = br.readLine();
		while (M-->0) {
			String comp = br.readLine() + "*";
			int idx = -1;
			for (int i = 0; i < N; i++) {
				char c = base.charAt(i);
				while (idx < comp.length()-1 && comp.charAt(++idx)!=c);
			}
			if (idx == comp.length()-1)
				bw.write("false\n");
			else
				bw.write("true\n");
		}
		bw.flush();
		br.close();
		bw.close();	
	}
}
