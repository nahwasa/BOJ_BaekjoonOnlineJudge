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
		if (a < b) {
			bw.write("-1\n");
			bw.flush();
			return;			
		}			
		int r1 = a+b;
		int r2 = a-b;
		if (r1%2!=0 || r2%2!=0)
			bw.write("-1\n");
		else
			bw.write(String.format("%d %d\n", r1/2, r2/2));	
		
		bw.flush();
		bw.close();
		br.close();
	}
}
