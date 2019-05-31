import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		int aPos = 0;
		int bPos = 0;
		
		for (int i = 0; i < a.length(); i++) {
			boolean chk = false;
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i) == b.charAt(j)) {
					chk = true;
					aPos = i;
					bPos = j;
					break;
				}
			}
			if (chk)
				break;
		}
		
		for (int i = 0; i < b.length(); i++) {
			if (i == bPos)
				bw.write(a);
			else {
				for (int j = 0; j < a.length(); j++) {
					if (j == aPos)
						bw.write(b.charAt(i));
					else
						bw.write(".");
				}
			}
			bw.newLine();
		}
		
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
