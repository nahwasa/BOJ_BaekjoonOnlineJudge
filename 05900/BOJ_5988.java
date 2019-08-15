import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			String s = br.readLine();
			int i = s.charAt(s.length()-1) - '0';
			bw.write((i&1)==1?"odd\n":"even\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
