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
		int TC = Integer.parseInt(br.readLine());	
		while (TC-->0) {
			int N = Integer.parseInt(br.readLine());			
			int max = Integer.MIN_VALUE;
			String maxName = "";
			while (N-->0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String nameTmp = st.nextToken();
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp > max) { max = tmp; maxName = nameTmp; }
			}
			bw.write(maxName+"\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}	
}
