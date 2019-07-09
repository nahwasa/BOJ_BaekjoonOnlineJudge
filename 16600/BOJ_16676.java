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
		int N = Integer.parseInt(in);
		if (N==0) {
			bw.write("1\n");
			bw.flush();
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < in.length(); i++)
			sb.append(1);
		if (N <= Integer.parseInt(sb.toString())-1)
			bw.write((in.length()-1) + "\n");
		else
			bw.write(in.length() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}	
}
