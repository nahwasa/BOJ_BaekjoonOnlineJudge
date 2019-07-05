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
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++)
			arr[i] = i;
		while (M-->0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int gap = e-s+1;
			for (int i = 0; i < gap/2; i++) {
				int tmp = arr[s+i];
				arr[s+i] = arr[e-i];
				arr[e-i] = tmp;
			}
		}
		for (int i = 1; i <= N; i++) {
			bw.write(arr[i] + " ");
		}
		bw.newLine();
		bw.flush();
		br.close();
		bw.close();		
	}
}
