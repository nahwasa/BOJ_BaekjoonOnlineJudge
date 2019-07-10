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
		if ((N&1)==0)
			bw.write("I LOVE CBNU\n");
		else {
			for (int i = 0; i < N; i++)
				bw.write("*");
			bw.newLine();
			for (int i = 0; i < N/2+1; i++) {
				for (int j = N/2-i; j > 0; j--) bw.write(" ");
				bw.write("*");
				for (int j = 1; j < i*2; j++) bw.write(" ");
				if (i!=0) bw.write("*");
				bw.newLine();
			}
		}		
		bw.flush();
		bw.close();
		br.close();
	}	
}
