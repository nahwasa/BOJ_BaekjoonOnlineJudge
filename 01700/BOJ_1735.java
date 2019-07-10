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
		int a1 = Integer.parseInt(st.nextToken());
		int a2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int b1 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());
		int r1 = a1*b2 + b1*a2;
		int r2 = a2*b2;
		int tmp1 = r1;
		int tmp2 = r2;
		int tmp0 = -1;
		while(tmp0!=0) {
			tmp0=tmp1%tmp2;
			tmp1=tmp2;
			tmp2=tmp0;
		}
		bw.write(String.format("%d %d\n", r1/tmp1, r2/tmp1));
		bw.flush();
		bw.close();
		br.close();
	}
}
