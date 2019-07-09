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
			for (int j = 0; j < N/2+N%2; j++) {
				bw.write("* ");
			}
			bw.newLine();
			bw.write(" ");
			for (int j = 0; j < N/2; j++) {
				bw.write("* ");
			}			
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}	
}
