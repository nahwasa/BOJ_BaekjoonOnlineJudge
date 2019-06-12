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
		while (TC-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				if (A<0&&B<0&&C<0) continue;
				sum += A>B?(A>C?A:C):(B>C?B:C);
			}
			bw.write(sum+"\n");
		}	
		bw.flush();
		br.close();
		bw.close();		
	}
}
