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
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] cntArr = new int[N+1];
		int cnt = 0;
		int idx = 1;
		while (true) {			
			cnt++;
			cntArr[idx]++;
			if (cntArr[idx] == M)
				break;
			if (cntArr[idx]%2==1)
				idx+=L;
			else
				idx-=L;
			if (idx>N) {
				idx--;				
				idx = idx%N + 1;
			}
			else if (idx<1)
				idx=N+(idx%N);			
		}
		bw.write((cnt-1)+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
