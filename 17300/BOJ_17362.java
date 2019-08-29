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
		if (N <= 5)
			bw.write(N + "\n");
		else {
			N-=5;
			if ((N/4) % 2 == 1) {
				bw.write((N%4)+1 + "\n");
			} else {
				bw.write(5-(N%4) + "\n");
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
