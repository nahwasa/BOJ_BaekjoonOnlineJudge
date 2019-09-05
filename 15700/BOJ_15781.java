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
		int M = Integer.parseInt(st.nextToken());
		int maxN = 0;
		int maxM = 0;
		st = new StringTokenizer(br.readLine());
		while (N-->0)
			maxN = Math.max(maxN, Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		while (M-->0)
			maxM = Math.max(maxM, Integer.parseInt(st.nextToken()));
		bw.write(maxN+maxM + "\n");		
		bw.flush();
		br.close();
		bw.close();	
	}
}
