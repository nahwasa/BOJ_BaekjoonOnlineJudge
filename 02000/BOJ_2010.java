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
		while (N-->0) {
			int n = Integer.parseInt(br.readLine());
			if (N==0)
				cnt += n;
			else
				cnt += (n-1);
		}
		bw.write(cnt + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
