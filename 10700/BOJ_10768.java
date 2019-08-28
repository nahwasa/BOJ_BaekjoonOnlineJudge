import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int m = Integer.parseInt(br.readLine());
		int d = Integer.parseInt(br.readLine());
		if (m<2)
			bw.write("Before\n");
		else if (m>2)
			bw.write("After\n");
		else if (d<18)
			bw.write("Before\n");
		else if (d>18)
			bw.write("After\n");
		else
			bw.write("Special\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
