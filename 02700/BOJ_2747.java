import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {	
	private static BigInteger[] fiboMem;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		fiboMem = new BigInteger[ (n <= 1)? 2 : n + 1];
		fiboMem[0] = new BigInteger("0");
		fiboMem[1] = new BigInteger("1");		

		bw.write(fibo(n).toString() + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
	
	private static BigInteger fibo(int n) {		
		if (fiboMem[n] != null)
			return fiboMem[n];
		
		BigInteger result = fibo(n-2).add(fibo(n-1));
		if (fiboMem[n] == null)
			fiboMem[n] = result;
		
		return result;
	}
}
