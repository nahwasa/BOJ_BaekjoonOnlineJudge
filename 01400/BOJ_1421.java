import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		for (int i = 1; i <= 10000; i++) {
			int sum = 0;			
			for (int j = 0; j < N; j++) {				
				int treeCnt = arr[j]/i;
				int cutCnt = (arr[j]%i==0?treeCnt-1:treeCnt);
				int tmp = treeCnt*i*W-cutCnt*C;
				if (tmp > 0)
					sum += tmp;
			}
			max = Math.max(max, sum);
		}
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}	
}
