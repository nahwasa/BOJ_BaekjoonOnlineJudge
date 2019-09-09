import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long min = Long.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long TC = Long.parseLong(br.readLine());
		int[][] s = new int[][] {
			{},
			{2,6,4},
			{1,3,5},
			{2,4,6},
			{5,3,1},
			{4,6,2},
			{1,5,3}
		};
		while (TC-->0) {
			long N = Long.parseLong(br.readLine());
			long[] arr = new long[7];
			StringTokenizer st = new StringTokenizer(br.readLine());
			long sum = 0;
			long day = 1;
			for (int i = 1; i <= 6; i++) {
				arr[i] = Long.parseLong(st.nextToken());
				sum += arr[i];
			}
			while (sum <= N) {
				long[] tmpArr = new long[7];
				sum = 0;
				day++;
				for (int i = 1; i <= 6; i++) {
					long tmp = arr[i];
					for (int j = 0; j < 3; j++) {
						tmp += arr[s[i][j]];
					}
					tmpArr[i] = tmp;
					sum += tmp;
				}
				arr = tmpArr;
			}
			bw.write(day + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
