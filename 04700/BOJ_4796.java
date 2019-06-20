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
		int day = 1;
		while (true) {
			String s = br.readLine();
			if (s.equals("0 0 0"))
				break;
			StringTokenizer st = new StringTokenizer(s);
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			bw.write(String.format("Case %d: %d\n", day++, V/P*L + (V%P<L?V%P:L)));
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
