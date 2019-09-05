import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<String> hs = new HashSet<String>();
		boolean chk = true;
		while (st.hasMoreTokens()) {
			if (!hs.add(st.nextToken()))
				chk = false;
		}
		bw.write((chk?"yes":"no") + "\n");			
		bw.flush();
		bw.close();
		br.close();
	}	
}
