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
		
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			HashSet<Integer> hs = new HashSet<Integer>();
			for (int i = 0; i < N; i++) {
				hs.add(Integer.parseInt(st.nextToken()));
			}
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());			
			for (int i = 0; i < N; i++) {
				if (hs.contains(Integer.parseInt(st.nextToken())))
					bw.write("1\n");
				else
					bw.write("0\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
