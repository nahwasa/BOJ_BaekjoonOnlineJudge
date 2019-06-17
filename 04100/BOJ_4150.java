import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		N=N<2?2:N;
		BigInteger[] arr = new BigInteger[N+1];
		arr[0] = new BigInteger("0");
		arr[1] = new BigInteger("1");
		for(int i = 2; i <= N; i++) {
			arr[i] = arr[i-2].add(arr[i-1]);
		}
		bw.write(arr[N].toString());		
		bw.flush();
		bw.close();
		br.close();
	}
}
