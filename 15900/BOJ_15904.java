import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		String s = br.readLine();
		String dst = "UCPC";
		int idx = 0;
		boolean isValid = true;
		for (int i = 0; i < dst.length(); i++) {
			int res = s.indexOf(dst.charAt(i), idx);
			if (res == -1) {isValid=false; break;}
			idx=res;
		}
		if (isValid) bw.write("I love UCPC\n");
		else bw.write("I hate UCPC\n");
		bw.flush();
		br.close();
		bw.close();
	}	
}
