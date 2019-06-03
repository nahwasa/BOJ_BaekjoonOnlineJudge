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
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
			if (tmp < 0)
				bw.write("advertise\n");
			else if (tmp > 0) 
				bw.write("do not advertise\n");
			else
				bw.write("does not matter\n");
		}
		
		bw.flush();		
		bw.close();
		br.close();
	}
}	
