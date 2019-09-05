import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int min = Math.min(L, R);
		int max = Math.max(L, R);
		if (min==max)
			bw.write((min+A/2)*2 + "\n");
		else if (max-min >= A)
			bw.write((min+A)*2 + "\n");
		else
			bw.write( (max+(A-(max-min))/2)*2 + "\n" );
		bw.flush();
		bw.close();
		br.close();
	}	
}
