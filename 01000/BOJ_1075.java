import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		
		N = (N / 100) * 100;	// 두자리 제거
		if (N % F != 0)
			N = (N / F) * F + F;
		String tmp = String.valueOf(N);
		bw.write(tmp.substring(tmp.length()-2));
		bw.flush();
		br.close();
		bw.close();		
	}
}
