import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		while(TC-->0) {
			int n = Integer.parseInt(br.readLine());
			int max = n;
			while (n != 1) {
				if (n%2 == 0)
					n/=2;
				else
					n = 3*n+1;
				if (n > max)
					max = n;
			}
			bw.write(max+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}	
}
