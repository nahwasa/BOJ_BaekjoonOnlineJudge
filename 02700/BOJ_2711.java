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
		
		int N = Integer.parseInt(br.readLine());
		while (N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int pos = Integer.parseInt(st.nextToken());
			bw.write(new StringBuilder(st.nextToken()).deleteCharAt(pos-1).toString() + "\n");
		}		
		bw.flush();
		bw.close();
		br.close();
	}
}
