import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i = 0;
		while (st.hasMoreTokens()) {
			arr[i++] = Integer.parseInt(st.nextToken());
		}
		int maxCnt = -1;
		for (i = 0; i < n; i++) {
			int cnt = 0;
			double rMax = Double.NEGATIVE_INFINITY;
			double lMax = Double.NEGATIVE_INFINITY;
			// chk right side
			for (int k = i+1; k < n; k++) {
				double slope = (double)(arr[k] - arr[i]) / (k - i);
				if (rMax < slope) {
					rMax = slope;
					cnt++;
				}
			}
			// chk left side
			for (int k = i-1; k >= 0; k--) {
				double slope = (double)(arr[k] - arr[i]) / (i - k);
				if (lMax < slope) {
					lMax = slope;
					cnt++;
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
		bw.write(String.valueOf(maxCnt));
		finish();
	}
	
	private static void finish() throws IOException {
		br.close();
		bw.flush();		
		bw.close();	
	}
}
