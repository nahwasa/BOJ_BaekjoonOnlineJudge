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
		
		int n = Integer.parseInt(br.readLine());
		
		int sM = 0;
		int sY = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int time = Integer.parseInt(st.nextToken());
			sM += (15 * (time/60 + 1));
			sY += (10 * (time/30 + 1));
		}
		
		if (sM == sY)
			bw.write("Y M " + sM + "\n");
		else if (sM < sY)
			bw.write("M " + sM + "\n");
		else
			bw.write("Y " + sY + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
