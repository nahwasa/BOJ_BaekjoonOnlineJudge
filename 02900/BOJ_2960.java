import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {	
	
	static int k = 0;
	static int cnt = 0;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		
		boolean[] pn = new boolean[n+1];
		for (int i = 2; i <= n; i++) {
			if (!pn[i]) {
				increaseCnt(i);
				int tmp = 1;
				while(true) {
					tmp++;
					int idx = tmp * i;
					if (idx > n)
						break;
					if (!pn[idx]) {
						pn[idx] = true;
						increaseCnt(idx);
					}
				}
			}
		}
    
		bw.write(result + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
	
	static void increaseCnt(int i) {
		cnt++;
		if (cnt == k)
			result = i;
	}
}
