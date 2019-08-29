import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = Integer.parseInt(br.readLine(), 2);
		int b = Integer.parseInt(br.readLine(), 2);
		long c = (long)a*b;		
		bw.write(Long.toString(c, 2));
		bw.flush();
		br.close();
		bw.close();
	}
}
