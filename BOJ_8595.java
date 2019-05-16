import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		long sum = 0;
		boolean contCheck = false;
		StringBuffer tmp = null;
		
		for (int i = 0; i < n; i++) {
			char target = str.charAt(i);
			
			if (target >= '0' && target <= '9') {	// 숫자
				if (!contCheck && target != 0) {
					tmp = new StringBuffer();					
					tmp.append(target);
					contCheck = true;					
				} else if (contCheck) {
					tmp.append(target);
					
					if (tmp.length() == 6) {
						contCheck = false;				
						sum += Integer.parseInt(tmp.toString());
						tmp = null;
					}
						
				}				
				continue;
			}	
			
			// 문자
			contCheck = false;
			if (tmp != null) {
				sum += Integer.parseInt(tmp.toString());
				tmp = null;
				
			}			
		
		}
		
		if (tmp!=null) {
			sum += Integer.parseInt(tmp.toString());
		}
		
		bw.write(sum + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}
}
