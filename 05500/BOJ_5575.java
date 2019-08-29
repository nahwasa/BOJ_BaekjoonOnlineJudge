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
		int tc = 3;
		while (tc-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken()) - h;			
			m = Integer.parseInt(st.nextToken()) - m;			
			s = Integer.parseInt(st.nextToken()) - s;
			if (s < 0) {s+=60; m-=1;}
			if (m < 0) {m+=60; h-=1;}			
			bw.write(String.format("%d %d %d\n", h,m,s));
		}		
		bw.flush();
		br.close();
		bw.close();
	}
}
