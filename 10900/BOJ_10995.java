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
		for (int i = 0; i < N; i++) {
			if (i%2==1) bw.write(" ");
			for (int j = 0; j < N; j++) {
				bw.write("*");
				if (j != N-1) bw.write(" ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}	
}
