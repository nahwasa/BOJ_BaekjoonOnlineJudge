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
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		boolean[] chk = new boolean[end + 1];
		chk[1] = true;
		for (int i = 2; i <= end / 2; i++) {
			if (!chk[i]) {
				for (int j = 2; i * j <= end; j++)
					chk[i * j] = true;
			}
		}
		
		for (int i = start; i <= end; i++) {
			if (!chk[i])
				bw.write(i + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
