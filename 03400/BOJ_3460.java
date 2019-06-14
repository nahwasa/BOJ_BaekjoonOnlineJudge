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
		while(TC-->0) {
			String b = Integer.toBinaryString(Integer.parseInt(br.readLine()));
			for (int i = b.length()-1; i >= 0; i--) {
				if (b.charAt(i) == '1')
					bw.write( (b.length() - i - 1) + " ");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}	
}
