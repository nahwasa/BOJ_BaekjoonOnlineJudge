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
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		int tmp = 0;
		for (int i = 0; i < M; i++) {
			int in = Integer.parseInt(st.nextToken());
			if (M == 1) { max=N-in>in?N-in:in; break; }
			if (i == 0) { max=in>max?in:max; tmp=in; continue; }
			int gap = in - tmp;
			tmp = in;
			max=gap/2+gap%2>max?gap/2+gap%2:max;
			if (i == M-1) { max=N-in>max?N-in:max; }
		}
		bw.write(max+"\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
