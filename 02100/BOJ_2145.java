import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {		
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;			
			while(N>=10) {
				int sum = 0;
				for (int i = 100000; i >= 1; i/=10) {					
					sum += N/i;
					N%=i;
				}
				N = sum;				
			}
			bw.write(N+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
