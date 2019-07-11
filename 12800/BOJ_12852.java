import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	private static int[] arr;
	private static StringBuilder sb;
	private static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N<4?4:N + 1];
		sb = new StringBuilder();
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		// DP
		for (int i = 4; i <= N; i++) {
			int min = arr[i-1];			
			if (i%3==0 && arr[i/3]<min) min = arr[i/3];
			if (i%2==0 && arr[i/2]<min)	min = arr[i/2];
			arr[i]=min+1;
		}
		cnt = arr[N];
		// backtrace
		backtrace(N);
		// output
		bw.write(arr[N] + "\n");
		bw.write(sb.toString());
		bw.newLine();
		bw.flush();
		br.close();
		bw.close();
	}
	private static void backtrace(int n) {
		if(n==1) { sb.append(1); return; }
		sb.append(n);
		sb.append(" ");
		if (n%3==0&&arr[n/3]==cnt-1) {cnt--; backtrace(n/3);}
		else if (n%2==0&&arr[n/2]==cnt-1) {cnt--; backtrace(n/2);}
		else if (arr[n-1]==cnt-1) {cnt--; backtrace(n-1);}
	}
}
