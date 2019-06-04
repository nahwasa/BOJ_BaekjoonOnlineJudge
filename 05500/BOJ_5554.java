import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int minSum = 0;
		for (int i = 0; i < 4; i++)
			minSum += Integer.parseInt(br.readLine());
		
		int x = minSum / 60;
		int y = minSum % 60;
		
		bw.write(x + "\n" + y + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
