import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] data = new String[] {
			"pi"
			,"ka"
			,"chu"
		};
		
		StringBuffer str = new StringBuffer(br.readLine());
		int availableCheck = str.length();
		
		for (int i = 0; i < data.length; i++) {
			while (true) {
				int idx = str.indexOf(data[i]);
				if ( idx == -1 )
					break;
				str.replace(idx, idx + data[i].length(), ",");
				availableCheck -= data[i].length();
			}
		}
		
		if (availableCheck == 0)
			bw.write("YES\n");
		else
			bw.write("NO\n");

		bw.flush();
		br.close();
		bw.close();		
	}	
}
