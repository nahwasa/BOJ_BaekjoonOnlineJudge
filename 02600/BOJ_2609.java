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
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int a = A>B?A:B;
		int b = A<B?A:B;
		int r = -1;
		while (r!=0) {
			r = a%b;
			a = b;
			b = r;
		}
		bw.write(a+"\n");
		bw.write((A*B/a) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}	
}
