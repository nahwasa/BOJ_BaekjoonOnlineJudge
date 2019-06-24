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
		int minPac = Integer.MAX_VALUE;
		int minSol = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		while (M-->0) {
			st = new StringTokenizer(br.readLine());
			int pac = Integer.parseInt(st.nextToken());
			int sol = Integer.parseInt(st.nextToken());
			minPac=pac<minPac?pac:minPac;
			minSol=sol<minSol?sol:minSol;
		}
		int sum = 0;
		if (N<6)
			sum += minPac<minSol*N?minPac:minSol*N;
		else {
			sum += N/6*minPac<N/6*6*minSol?N/6*minPac:N/6*6*minSol;
			if (N%6!=0) {
				sum += minPac<N%6*minSol?minPac:N%6*minSol;
			}
		}
		bw.write(sum+"\n");			
		bw.flush();
		br.close();
		bw.close();		
	}	
}
