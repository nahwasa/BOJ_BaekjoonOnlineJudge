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
		
		int n = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());
		int[] std = new int[n];
		
		for (int i = 0; i < n; i++)
			std[i] = Integer.parseInt(br.readLine());
		
		boolean[] chk = new boolean[time+1];
		
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int tmp = 1;
			while (true) {
				if (tmp * std[i] > time)
					break;
				if (!chk[tmp * std[i]]) {
					chk[tmp * std[i]] = true;
					cnt++;
				}
				tmp++;
			}
		}
		
		bw.write(cnt+"\n");
		
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
