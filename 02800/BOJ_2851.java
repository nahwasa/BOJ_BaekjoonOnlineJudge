import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] tmp = new int[10];
		
		int sum = 0;
		int min = 0;
		for (int i = 0; i < 10; i++) {
			int m = Integer.parseInt(br.readLine());
			sum += m;
			tmp[i] = 100 - sum;
			
			
			
			if (Math.abs(tmp[i]) <= tmp[min])
				min = i;
				
		}

		bw.write(100 - tmp[min] + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
}	
