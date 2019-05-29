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
		int[] arr = new int[n+1];
		arr[0] = 1;
		arr[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			arr[i] = (arr[i-2] + arr[i-1]) % 10007;
		}
		
		bw.write(arr[n] + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}
}
