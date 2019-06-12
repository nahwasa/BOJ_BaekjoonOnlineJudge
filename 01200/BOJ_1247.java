import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		for (int i = 0; i < 3; i++) {
			
			int N = Integer.parseInt(br.readLine());
			N = N==0?1:N;
			BigInteger sum = new BigInteger("0");
			for (int j = 0; j < N; j++) {
				sum = sum.add(new BigInteger(br.readLine()));
			}
			int compare = sum.compareTo(new BigInteger("0"));
			if (compare == 0)
				bw.write("0\n");
			else if (compare < 0)
				bw.write("-\n");
			else
				bw.write("+\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
