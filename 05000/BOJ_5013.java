import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {			
			if (!br.readLine().contains("CD"))
				cnt++;
		}
		
		bw.write(cnt + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
