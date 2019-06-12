import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		if (x > y) {
			int tmp = y;
			y = x;
			x = tmp;
		}
		double tmp = Math.sqrt(x*x+y*y);
		bw.write(String.format("%d %d\n", (int)(x*(a/tmp)), (int)(y*(a/tmp))));
		bw.flush();
		br.close();
		bw.close();		
	}
}
