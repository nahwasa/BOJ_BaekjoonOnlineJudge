import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (N==0 && M==0)
				break;
			HashSet<String> hs = new HashSet<String>();
			while(N-->0)
				hs.add(br.readLine());
			int cnt = 0;
			while(M-->0)
				if (hs.contains(br.readLine())) cnt++;
			bw.write(cnt+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
