import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			int N = Integer.parseInt(br.readLine());
			HashSet<String> hs = new HashSet<String>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (N-->0) {
				String in = st.nextToken();
				if (hs.contains(in))
					hs.remove(in);
				else
					hs.add(in);
			}
			bw.write(String.format("Case #%d: %s\n", i+1, hs.iterator().next()));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
