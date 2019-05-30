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
			bw.write(getNumOfYear(st) + "\n");
		}
		
				
		bw.flush();
		br.close();
		bw.close();		
	}

	private static long getNumOfYear(StringTokenizer st) {
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		if (x == 1 && y == 1)
			return 1;

		if (m < x || n < y || m < 1 || n < 1 || x < 1 || y < 1)	//exception
			return -1;

		long year = x;
		int cnt = x;
		cnt = x % n == 0 ? n : x % n;
		int chk = cnt;
		if (cnt == y)
			return year;
		
		
		
		while (true) {
			cnt += m;
			year += m;
			cnt = cnt % n == 0 ? n : cnt % n;			
			
			if (cnt == y)
				return year;
			
			if (cnt == chk)
				return -1;
		}
	}	
}
