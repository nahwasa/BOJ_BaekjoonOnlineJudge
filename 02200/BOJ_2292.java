import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		int n = Integer.parseInt(br.readLine());
		if (n == 1) {
			bw.write("1\n");
			bw.flush();
			return;
		}
		
		long tmp = 1;
		int t = 6;
		int cnt = 1;
		while (true) {
			cnt++;
			tmp += t;
			t += 6;
			if (n <= tmp)
				break;
		}
		bw.write(cnt + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
