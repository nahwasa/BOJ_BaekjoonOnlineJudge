import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		long sum = 0;
		for (long i = 1; i <= N-1; i++)
			sum += N*i+i;
		bw.write(sum+"\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
