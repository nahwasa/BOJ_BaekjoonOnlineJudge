import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String in = br.readLine();
		if (in.length()==4)
			bw.write("20\n");
		else if (in.length()==2)
			bw.write(String.valueOf(in.charAt(0) + in.charAt(1) - 2*'0'));
		else if (in.charAt(1)=='0')
			bw.write((10+in.charAt(2)-'0') + "\n");
		else 
			bw.write((10+in.charAt(0)-'0') + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
