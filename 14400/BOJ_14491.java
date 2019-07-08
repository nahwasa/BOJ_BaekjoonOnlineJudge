import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 4; i >= 0; i--) {
			int tmp = (int) Math.pow(9, i);
			sb.append(T/tmp);
			T%=tmp;
		}
		bw.write(Integer.parseInt(sb.toString()) + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
