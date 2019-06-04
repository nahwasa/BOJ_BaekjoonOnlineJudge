import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[n-i-1] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for (int i = 0; i < n-1; i++) {
			if (arr[i+1] >= arr[i]) {
				cnt += (arr[i+1]-arr[i]+1);
				arr[i+1] = arr[i] - 1;
			}
		}
	
		bw.write(cnt + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
