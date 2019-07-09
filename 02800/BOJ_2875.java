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
		int K = Integer.parseInt(st.nextToken());
		K-=N%2;
		N-=N%2;
		if (N>M*2) {
			int gap = N-M*2;
			K-=gap;
			N-=gap;
		} else if (N<M*2) {
			int gap = M-N/2;
			K-=gap;
			M-=gap;
		}
		int team = (N+M)/3;	
		if (K<=0)
			bw.write(team+"\n");
		else 
			bw.write((team-K/3-(K%3==0?0:1)) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}	
}
