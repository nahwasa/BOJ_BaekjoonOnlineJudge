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
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int tmp = 1;
			for (int j = 0; j < b; j++) {
				tmp = (tmp * a) % 10;
			}
			if (tmp == 0)
				tmp = 10;
			bw.write(tmp + "\n");
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
