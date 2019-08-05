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
		while (true) {
			String s = br.readLine();
			if (s.equals("0 0 0 0")) break;
			StringTokenizer st = new StringTokenizer(s);
			int max = -Integer.parseInt(st.nextToken());
			int min = -Integer.parseInt(st.nextToken());			
			min += Integer.parseInt(st.nextToken());
			max += Integer.parseInt(st.nextToken());
			bw.write(String.format("%d %d\n", min, max));
		}		
		bw.flush();
		br.close();
		bw.close();		
	}
}
