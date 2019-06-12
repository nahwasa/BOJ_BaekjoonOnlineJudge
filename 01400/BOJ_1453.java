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
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] chk = new boolean[101];
		int cnt = 0;
		while (N-->0) {
			int tmp = Integer.parseInt(st.nextToken());
			if (!chk[tmp])
				chk[tmp] = true;
			else
				cnt++;
		}
		bw.write(cnt+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
