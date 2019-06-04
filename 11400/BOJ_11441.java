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
		int[] sum = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		sum[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < n; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a == 1)
				bw.write(sum[b-1] + "\n");
			else
				bw.write((sum[b-1]-sum[a-2]) + "\n");
		}
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
