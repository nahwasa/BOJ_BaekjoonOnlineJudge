import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		int sixTmp = 0;
		int max = -1;
		
		for (int i = 0; i < 10; i++) {
			int cnt = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) - '0' == i)
					cnt++;
			}
			if (i == 6) {
				sixTmp = cnt;
			} else {
				if (i == 9) {
					int remain = (sixTmp + cnt) % 2;
					cnt = ((sixTmp + cnt) / 2) + remain;
				}				
				if (max < cnt) {					
					max = cnt;
				}
			}
		}
		
		bw.write(max + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
