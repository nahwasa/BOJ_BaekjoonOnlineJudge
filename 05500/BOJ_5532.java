import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int l = Integer.parseInt(br.readLine());
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int d = Integer.parseInt(br.readLine());
		
		int calc = (a/c + (a%c==0?0:1)) > (b/d + (b%d==0?0:1)) ? (a/c + (a%c==0?0:1)) : (b/d + (b%d==0?0:1));
		bw.write((l - calc) + "\n");
			
		bw.flush();		
		bw.close();
		br.close();
	}
}
