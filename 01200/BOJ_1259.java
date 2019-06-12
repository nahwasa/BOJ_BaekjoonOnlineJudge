import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		while (true) {
			StringBuilder s = new StringBuilder(br.readLine());
			if (s.toString().equals("0"))
				break;
			if (s.toString().equals(s.reverse().toString()))
				bw.write("yes\n");
			else
				bw.write("no\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
