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
		StringTokenizer st = new StringTokenizer(br.readLine(), ":");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int r = 1;
		int big = a>b?a:b;
		int sma = a<b?a:b;		
		while (r>0) {
			r=big%sma;
			big=sma;
			sma=r;
		}
		bw.write(String.format("%d:%d\n", a/big, b/big));
		bw.flush();
		br.close();
		bw.close();
	}
}
