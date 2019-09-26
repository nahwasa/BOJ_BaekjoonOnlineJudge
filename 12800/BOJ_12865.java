import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Thing[] arr = new Thing[N];
		int[] dp = new int[K+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for (int i = 0; i < N; i++)
			arr[i] = new Thing(br.readLine());		
		for (int i = 0; i < N; i++) {
			int wTmp = arr[i].w;
			for (int k = K; k >= 0; k--) {
				if (dp[k] != -1 && k+wTmp <= K)
					dp[k+wTmp] = Math.max(dp[k+wTmp], dp[k] + arr[i].v);
			}
		}
		int max = 0;
		for (int value : dp)
			max = Math.max(max, value);
		bw.write(max + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}	
}

class Thing implements Comparable<Thing>{
	int w,v;
	public Thing(String s) {
		StringTokenizer st = new StringTokenizer(s);
		this.w = Integer.parseInt(st.nextToken());
		this.v = Integer.parseInt(st.nextToken());
	}
	@Override
	public int compareTo(Thing o) {
		if (this.w==o.w)
			return this.v-o.v;
		return this.w-o.w;
	}
	
}
