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
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), ",");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int k =1; k <= K; k++) {
			for (int i = 0; i < N-k; i++) {
				arr[i] = arr[i+1]-arr[i];
			}
		}
		for (int i = 0; i < N-K; i++)
			bw.write(arr[i] + (i==N-K-1?"\n":","));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
