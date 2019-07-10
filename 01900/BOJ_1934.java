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
		while(TC-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int mul = A*B;
			int r = -1;
			while(r!=0) {
				r=A%B;
				A=B;
				B=r;
			}
			bw.write((mul/A) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
