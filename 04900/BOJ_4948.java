import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		boolean[] pn = new boolean[123456 * 2 + 1];
		for (int i = 2; i <= 123456; i++) {
			if (!pn[i]) {
				int tmp = 1;
				while(true) {
					tmp++;
					int idx = tmp * i;
					if (idx > 123456*2)
						break;
					pn[idx] = true;
				}
			}
		}
		
		while(true) {
			int in = Integer.parseInt(br.readLine());
			if (in == 0)
				break;
			
			int cnt = 0;
			for (int i = in+1; i <= 2*in; i++)
				if (!pn[i])
					cnt++;
			bw.write(cnt+"\n");
		}
		
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
