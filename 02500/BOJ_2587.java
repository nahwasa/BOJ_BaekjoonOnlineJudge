import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int sum = 0;
		int[] tmp = new int[5];
		
		for (int i = 1; i <= 5; i++) {
			int n = Integer.parseInt(br.readLine());
			sum += n;
			tmp[i-1] = n;			
		}
		
		bw.write( sum/5 + "\n" );
		
		Arrays.sort(tmp);
		bw.write( tmp[2] + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
