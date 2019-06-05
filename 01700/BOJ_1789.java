import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	
	static int k = 0;
	static int cnt = 0;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long n = Long.parseLong(br.readLine());
		long tmp = 0;
		
		long i = 0;
		while (tmp <= n) {
			i++;
			tmp += i;			
		}
		bw.write(i-1 + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}	
}
