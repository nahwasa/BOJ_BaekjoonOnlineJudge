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
		int K = Integer.parseInt(st.nextToken());
		double[] arr = new double[N];
		for(int i=0; i<N; i++) 
			arr[i]=Double.parseDouble(br.readLine());
		Arrays.sort(arr);
		double sum = 0.0;
		for (int i=K; i<N-K; i++)
			sum+=arr[i];
		bw.write(String.format("%.2f\n", (sum/(N-2*K))));
		sum+=(arr[K]*K);
		sum+=(arr[N-K-1]*K);
		bw.write(String.format("%.2f\n", (sum/N)));
		bw.flush();
		br.close();
		bw.close();
	}
}
