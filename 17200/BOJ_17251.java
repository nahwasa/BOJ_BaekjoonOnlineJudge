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
		//initialize
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());		
		int max = 0;
		int left=-1,right=-1;
		int m = N/2;
		//input & process		
		for (int i = 0; i < m; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp>max) { 
				max=tmp; left=m-i; 
			}
		}
		for (int i = m; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp>max) {
				bw.write("B\n");
				bw.flush();
				return;
			}
			if (tmp==max) {
				right=i-m+1;
			}
		}
		if (left==right) bw.write("X\n");
		else if (left>right) bw.write("R\n");
		else bw.write("B\n");		
		bw.flush();
		br.close();
		bw.close();
	}
}
