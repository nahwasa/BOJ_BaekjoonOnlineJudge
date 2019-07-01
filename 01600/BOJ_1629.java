import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int A, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		bw.write(pow(B) + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

	private static long pow(int b) {
		if (b == 0)
			return 1;
		long tmp = pow(b/2);
		tmp = tmp * tmp % C;
		if (b%2==0)
			return tmp;
		return A*tmp%C;
	}
}
