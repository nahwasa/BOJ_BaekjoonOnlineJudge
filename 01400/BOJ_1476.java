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
		
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		bw.write(calcYear(e, s, m) + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}

	private static int calcYear(int e, int s, int m) {
		int result = 0;
		
		int eTmp = 0;
		int sTmp = 0;
		int mTmp = 0;
		
		while(true) {		
			++result;
			if (++eTmp > 15)
				eTmp = 1;
			if (++sTmp > 28)
				sTmp = 1;
			if (++mTmp > 19)
				mTmp = 1;
			
			if (eTmp == e && sTmp == s && mTmp == m)
				break;
		}
		
		return result;
	}
}
