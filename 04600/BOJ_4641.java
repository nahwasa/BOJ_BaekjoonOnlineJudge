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
		
		while(true) {
			String str = br.readLine();
			if (str.equals("-1"))
				break;
			
			StringTokenizer st = new StringTokenizer(str);
			boolean[] num = new boolean[100];	// 입력이 100보다 작으므로 
						
			while(st.hasMoreTokens()) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 0)
					break;
				
				num[a] = true;
			}
			
			int cnt = 0;
			for (int i = 1; i <= 49; i++) {
				if (num[i] && num[i*2])
					cnt++;
			}
			bw.write(cnt + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();		
	}	

}
