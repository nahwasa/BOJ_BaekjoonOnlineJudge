import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		HashSet<String> hs = new HashSet<String>();
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			hs.add(tmp);
			if (hs.contains(new StringBuilder(tmp).reverse().toString())) {
				bw.write(tmp.length() + " ");
				bw.write(tmp.charAt(tmp.length()/2) + "\n");
			}
		}
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
