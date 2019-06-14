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
		int N = Integer.parseInt(br.readLine()) - 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		while (N-->0) {
			int t = Integer.parseInt(st.nextToken());
			int gcd = 0;
			for (int i = (r<t?r:t); i>=1; i--)
				if (r%i==0&&t%i==0) {gcd=i; break;}
			bw.write(String.format("%d/%d\n", r/gcd, t/gcd));			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}	
