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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Long.parseLong(st.nextToken());
		for (int i = 0; i < M; i++) {
			Arrays.sort(arr);
			long tmp = arr[0]+arr[1];
			arr[0] = tmp;
			arr[1] = tmp;
		}
		long sum = 0;
		for (long l : arr)
			sum += l;
		bw.write(sum + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
