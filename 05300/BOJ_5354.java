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
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			int N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {				
				for (int j = 0; j < N; j++) {
					if (i==0 || j==0 || i==N-1 || j==N-1)
						sb.append('#');
					else
						sb.append('J');
				}
				sb.append("\n");
			}
			bw.write(sb.toString());
			
			if (TC != 0)
				bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
