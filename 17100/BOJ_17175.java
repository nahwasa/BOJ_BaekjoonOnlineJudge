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
		if (n == 0 || n == 1) {
			bw.write("1\n");
			bw.flush();
			return;
		}		

		int[] tmp = new int[n + 1];
		tmp[0] = 1;
		tmp[1] = 1;

		for(int i = 2; i <= n; i++) {
			tmp[i] = (tmp[i-2] + tmp[i-1] + 1) % 1000000007;
		}

		bw.write( tmp[n] + "\n");

		bw.flush();
		bw.close();
		br.close();
	}	
}
