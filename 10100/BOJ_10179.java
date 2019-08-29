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
		while (N-->0) {
			double d = Double.parseDouble(br.readLine());
			bw.write(String.format("$%.2f\n", d*0.8));
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
