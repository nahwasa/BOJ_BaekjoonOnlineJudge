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
		
		int cnt = 0;
		int max = 0;
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cnt -= Integer.parseInt(st.nextToken());
			if (cnt>max) max = cnt;
			cnt += Integer.parseInt(st.nextToken());
			if (cnt>max) max = cnt;
		}		
		bw.write(max+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
