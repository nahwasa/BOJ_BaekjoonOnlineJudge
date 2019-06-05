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
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] cnt = new int[5];
		
		for (int i = 0; i < M; i++) {
			br.readLine();	// 버림
			boolean[] chk = new boolean[N];			
			for (int j = 0; j < 4; j++) {
				String s = br.readLine();
				
				for (int k = 0; k < N; k++) {
					if (chk[k])	// 이미 체킹됨
						continue;
					
					if (s.charAt(k * 5 + 1) == '.') {
						chk[k] = true;
						cnt[j]++;
					}
				}
			}
			
			for (int j = 0; j < N; j++)
				if (!chk[j])
					cnt[4]++;
		}
		br.readLine();	// 버림
		
		bw.write(cnt[0] + " " + cnt[1] + " " + cnt[2] + " " + cnt[3] + " " + cnt[4] + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}	
}
