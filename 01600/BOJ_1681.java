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
		int N = Integer.parseInt(st.nextToken());
		char L = st.nextToken().charAt(0);
		int tmp = 0;
		while(N>0) {
			tmp++;
			if(String.valueOf(tmp).indexOf(L)!=-1) continue;
			N--;
		}
		bw.write(tmp+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
