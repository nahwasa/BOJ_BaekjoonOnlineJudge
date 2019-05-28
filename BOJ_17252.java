import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long n = Long.parseLong(br.readLine());
		if (n == 0) {
			bw.write("NO\n");
			bw.flush();
			br.close();
			bw.close();	
			return;
		}
		
		int i = 0;
		long tmp = 1;
		while (true) {
			if (tmp > n)
				break;
			
			tmp *= 3;
			i++;
		}
		
		for (; i >= 0; i--) {
			if (n >= tmp) {		
				n -= tmp;
			}
			
			if (n == 0) {
				bw.write("YES\n");
				bw.flush();
				br.close();
				bw.close();	
				return;
			}
			
			tmp /= 3;
		}
		
		bw.write("NO\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}
}
