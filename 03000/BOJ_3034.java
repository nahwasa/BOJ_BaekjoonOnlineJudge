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
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		double len = Math.sqrt(w*w + h*h);
		
		for (int i = 0; i < n; i++) {
			if (Integer.parseInt(br.readLine()) <= len)
				bw.write("DA\n");
			else
				bw.write("NE\n");
		}
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
