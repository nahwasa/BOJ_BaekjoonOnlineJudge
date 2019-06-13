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
		int calc = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			bw.write((Integer.parseInt(st.nextToken()) - calc) + " ");
		}
		bw.newLine();
		
		bw.flush();
		bw.close();
		br.close();
	}
}
