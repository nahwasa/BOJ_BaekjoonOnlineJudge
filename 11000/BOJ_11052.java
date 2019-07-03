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
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());		
		for (int i = 1; i <= N; i++) {
			int max = arr[i] = Integer.parseInt(st.nextToken());
			for (int j = i/2; j >= 1; j--) {
				int tmp = arr[j] + arr[i-j];
				if (tmp > max) max = tmp;
			}
			arr[i] = max;
		}	
		bw.write(arr[N] + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
