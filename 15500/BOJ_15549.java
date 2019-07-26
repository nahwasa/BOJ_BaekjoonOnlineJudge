import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int x = Integer.MIN_VALUE; x <= Integer.MAX_VALUE; x++) {
			if (x != 0 && x == -x) {
				bw.write(String.valueOf(x));
				break;
			}
		}		
		bw.close();
		br.close();
	}
}
