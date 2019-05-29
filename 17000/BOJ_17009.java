import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a3 = Integer.parseInt(br.readLine());
		int a2 = Integer.parseInt(br.readLine());
		int a1 = Integer.parseInt(br.readLine());
		
		int b3 = Integer.parseInt(br.readLine());
		int b2 = Integer.parseInt(br.readLine());
		int b1 = Integer.parseInt(br.readLine());
		
		int aSum = a3*3 + a2*2 + a1;
		int bSum = b3*3 + b2*2 + b1;
		
		if (aSum == bSum) {
			bw.write("T\n");			
		} else if (aSum > bSum) {
			bw.write("A\n");
		} else {
			bw.write("B\n");
		}
		
		
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
