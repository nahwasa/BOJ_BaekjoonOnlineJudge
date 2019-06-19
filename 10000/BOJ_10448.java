import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] T = new int[45];
		for (int i = 1; i < T.length; i++)	// T[n] = 1+2+...+n, T[44]=990
			T[i] = i * (i+1) / 2;
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			int N = Integer.parseInt(br.readLine());
			boolean chk = false;
			for (int i = 1; i < T.length; i++) {
				for (int j = 1; j < T.length; j++) {
					for (int k = 1; k < T.length; k++) {
						if (T[i] + T[j] + T[k] == N) {
							chk = true;
							break;
						}
					}
					if(chk) break;
				}
				if(chk) break;
			}			
			if (!chk) bw.write("0\n");
			else bw.write("1\n");
		}
		
		bw.flush();
		br.close();
		bw.close();		
	}
}
