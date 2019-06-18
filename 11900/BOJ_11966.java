import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int N = Integer.parseInt(br.readLine());
		boolean chk = false;
		for (int i = 0; i <= 30; i++) {
			if ((int)Math.pow(2, i) == N) {
				bw.write("1\n");
				chk = true;
				break;
			}
		}
		if (!chk)
			bw.write("0\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
