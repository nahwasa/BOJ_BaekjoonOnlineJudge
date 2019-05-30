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
		
		if (n == 1) {
			bw.write("0\n");
			bw.flush();
			br.close();
			bw.close();		
			return;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int max = 0;
		int h = Integer.parseInt(st.nextToken());
		int beforeH;
		int tmp = 0;
		
		for (int i = 0; i < n-1; i++) {
			beforeH = h;
			h = Integer.parseInt(st.nextToken());
			
			if (h > beforeH) {
				tmp += h - beforeH;
			} else {
				if (tmp > max)
					max = tmp;
				tmp = 0;
			}
		}
		
		bw.write((max>tmp?max:tmp) + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
