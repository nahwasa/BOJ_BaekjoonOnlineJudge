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
		double sum = 0.0;
		for (int i = 0; i < n; i++)
			sum += Integer.parseInt(br.readLine());
		
		bw.write(sum / n < 0.5 ? "Junhee is not cute!\n" : "Junhee is cute!\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
}	
