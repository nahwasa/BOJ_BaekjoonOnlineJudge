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
		int n = Integer.parseInt(st.nextToken());
		int dst = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for (int i = n-1; i >= 0; i--) {
			if (arr[i] > dst)
				continue;
			
			cnt += dst / arr[i];
			dst %= arr[i];
			if (dst == 0)
				break;
		}
		
		bw.write(cnt + "\n");
				
		bw.flush();
		br.close();
		bw.close();		
	}
}
