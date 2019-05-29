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
		
		int n = Integer.parseInt(br.readLine());
		
		if (n <= 1) {
			bw.write("0\n");
			return;
		}
				
		int[] num = new int[n];
		int maxNum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			if (num[i] > maxNum)
				maxNum = num[i];
		}
		
		boolean[] pn = new boolean[maxNum+1];	//false : 소수
		pn[1] = true;	// 1은 소수가 아님
		
		for(int i = 2; i <= maxNum / 2; i++) {
			if (!pn[i]) {	// 소수거나 아직 체크하지 않았다면				
				int tmp = 2;
				int pos = i;
				while(true) {
					int p = pos * tmp++;
					if (p > maxNum)
						break;
					pn[p] = true;
				}
			}
		}		
		
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (!pn[ num[i] ])
				cnt++;
		}
		
		bw.write(cnt + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}
}
