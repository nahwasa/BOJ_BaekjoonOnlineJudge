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
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
				
		if (a == b && b == c) {
			bw.write((10000 + 1000 * a) + "\n");
		} else if (a == b || b == c || a == c) {
			int sameNum = a==b?a : (b==c?b : c);
			bw.write(1000 + 100 * sameNum + "\n");
		} else {
			int maxNum = a>b?a: (b>c?b:c);
			bw.write(100 * maxNum + "\n");
		}
				
		bw.flush();
		br.close();
		bw.close();		
	}	
}
