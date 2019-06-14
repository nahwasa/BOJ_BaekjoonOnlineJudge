import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			String s = br.readLine();
			if (s.equals("***"))
				break;
			StringBuilder sb = new StringBuilder(s);
			bw.write(sb.reverse().toString() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
