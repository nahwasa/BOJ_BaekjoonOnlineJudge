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
		int cmp = Integer.parseInt(st.nextToken());
		while(st.hasMoreTokens()) {
			int tmp = Integer.parseInt(st.nextToken());
			if (cmp > tmp) {
				bw.write("Bad\n");
				bw.flush();
				return;
			}
			cmp=tmp;
		}
		bw.write("Good\n");
		bw.flush();
		bw.close();
		br.close();
	}	
}
