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
		while (true) {
			for (int i = 2; i <= N; i++) {
				if (N%i==0) {
					bw.write(i+"\n");
					N/=i;
					break;
				}
			}
			if (N==1)
				break;
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
