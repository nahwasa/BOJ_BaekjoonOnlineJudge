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
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			boolean chk = N%H==0;
			bw.write(String.format("%d%02d\n", (!chk?N%H:H), N/H + (!chk?1:0)) );
		}
		bw.flush();
		bw.close();
		br.close();
	}	
}
