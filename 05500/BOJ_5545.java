import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);		
		int sum = C;
		int max = sum/A;
		for (int i = N-1; i>=0; i--) {
			sum += arr[i];
			A+=B;
			int tmp = sum/A;
			if (tmp>max) max=tmp;
		}
		bw.write(max+"\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
