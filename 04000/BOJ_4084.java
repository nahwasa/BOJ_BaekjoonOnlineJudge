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
				
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if (a == 0 && b == 0 && c == 0 && d == 0)
				break;
			int cnt = 0;
			while (true) {				
				if (a == b && b == c && c == d && d == a)
					break;
				cnt++;
				int tmpA = Math.abs(a-b);
				int tmpB = Math.abs(b-c);
				int tmpC = Math.abs(c-d);
				int tmpD = Math.abs(d-a);				
				a = tmpA;
				b = tmpB;
				c = tmpC;
				d = tmpD;
			}
			bw.write(cnt+"\n");			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}	
}
