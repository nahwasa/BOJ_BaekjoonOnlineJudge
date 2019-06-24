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
		boolean[] arr = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		while (M-->0) {
			int n = Integer.parseInt(st.nextToken());
			int idx = 1;
			int tmp = n;
			while (tmp <= N) {				
				arr[tmp] = true;
				tmp = n * ++idx;
			}
		}
		int sum = 0;
		for (int i = 2; i <= N; i++)
			if (arr[i]) sum+=i;
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
		br.close();
	}	
}
