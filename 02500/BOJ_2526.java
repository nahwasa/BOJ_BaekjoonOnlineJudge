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
		int P = Integer.parseInt(st.nextToken());
		int[] chk = new int[P];
		int cnt = 1;
		int calc = N%P;
		while (chk[calc]==0) {
			chk[calc] = cnt++;
			calc = (calc * N) % P;			
		}
		bw.write((cnt - chk[calc]) + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
